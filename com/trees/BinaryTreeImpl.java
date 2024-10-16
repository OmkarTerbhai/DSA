package com.trees;

import java.util.*;

class Pair {
    BinaryTreeImpl.Node node;
    int num;

    public Pair(BinaryTreeImpl.Node node, int num) {
        this.node = node;
        this.num = num;
    }
}
public class BinaryTreeImpl {
    static Scanner in = new Scanner(System.in);
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class Pair {
        Node node;
        int num;

        public Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    static Node root;

    public static void main(String[] args) {
        BinaryTreeImpl b = new BinaryTreeImpl();
        b.init();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        b.iterativeDFSTravel(root, preOrder, inOrder, postOrder);

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

    public  void init() {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

    }
    private void insertRoot(int data) {
        root = new Node(data);
        insertNodes(root);
    }

    private void insertNodes(Node root) {
        if(Objects.isNull(root)) {
            return;
        }

        System.out.println("Enter left or right of " + root.data);
        String dir = in.nextLine();
        System.out.println("Enter data: ");
        int data = in.nextInt();
        if("left".equals(dir)) {
            root.left = new Node(data);
            insertNodes(root.left);
        }
        else {
            root.right = new Node(data);
            insertNodes(root.right);
        }
    }

    /*
     * Node Left Right
     */
    void preOrder(Node node) {
        if(Objects.isNull(node)) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /*
     *   Left Node Right
     */
    void inOrder(Node node) {
        if(Objects.isNull(node)) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /*
     *  Left Right Node
     */
    void postOrder(Node node) {
        if(Objects.isNull(node)) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    void preOrder(Node node, int ele) {
        if(Objects.isNull(node)) {
            return;
        }
        if(node.data == ele) {
            System.out.println("Found");
            return;
        }
        preOrder(node.left, ele);
        preOrder(node.right, ele);
    }

    int findHeight(Node node, int h) {
        if(Objects.isNull(node)) {
            return -1;
        }

        int lH = findHeight(node.left, h+1);
        int rH = findHeight(node.right, h+1);

        return Math.max(rH, lH) + 1;
    }

    void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 1; i <= n; i++) {
                Node ans = queue.poll();
                if(ans != null) {
                    if (ans.left != null) queue.add(ans.left);
                    if (ans.right != null) queue.add(ans.right);

                    System.out.print(ans.data + " ");
                }

            }
            System.out.println();
        }
    }

    public void iterativePreOrder(Node root) {
        if(null == root) return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node rem = st.pop();
            System.out.print(rem.data + " ");

            if(rem.right != null) {
                st.push(rem.right);
            }
            if(rem.left != null) {
                st.push(rem.left);
            }
        }
    }

    public void iterativeInorder(Node node) {
        Stack<Node> st = new Stack<>();

        while (true) {
            if(node != null) {
                st.push(node);
                node = node.left;
            }
            else {
                if(st.isEmpty()) break;
                Node rem = st.pop();
                System.out.print(rem.data + " ");
                node = rem.right;
            }
        }
    }

    public void iterativePostOrder(Node node) {
        if(node == null) return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(node);
        while(!st1.isEmpty()) {
            Node rem = st1.pop();
            st2.push(rem);
            if(rem.left != null) st1.push(rem.left);
            if(rem.right != null) st1.push(rem.right);
        }

        while(!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }
    }

    public void iterativeDFSTravel(Node node, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder) {
        if(node == null) return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));

        while (!st.isEmpty()) {
            Pair rem = st.pop();

            if(rem.num == 1) {
                preOrder.add(rem.node.data);

                st.push(new Pair(rem.node, 2));
                if(rem.node.left != null) {
                    st.push(new Pair(rem.node.left, 1));
                }
            } else if (rem.num == 2) {
                inOrder.add(rem.node.data);

                st.push(new Pair(rem.node, 3));
                if(rem.node.right != null)
                    st.push(new Pair(rem.node.right, 1));
            }
            else {
                postOrder.add(rem.node.data);
            }
        }
    }

}
