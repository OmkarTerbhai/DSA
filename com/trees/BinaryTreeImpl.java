package com.trees;

import com.sun.source.tree.Tree;

import java.util.*;

class Pair {
    BinaryTreeImpl.TreeNode treeNode;
    int num;

    public Pair(BinaryTreeImpl.TreeNode treeNode, int num) {
        this.treeNode = treeNode;
        this.num = num;
    }
}
public class BinaryTreeImpl {
    static Scanner in = new Scanner(System.in);
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    class Pair {
        TreeNode treeNode;
        int num;

        public Pair(TreeNode treeNode, int num) {
            this.treeNode = treeNode;
            this.num = num;
        }
    }

    static TreeNode root;

    public static void main(String[] args) {
        BinaryTreeImpl b = new BinaryTreeImpl();
        b.init();

        int[] post = {9,15,7,20,3};
        int[] in = {9,3,15,20,7};

        TreeNode r = b.buildTree(in, post);
        b.inOrder(r);
    }

    public  void init() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

    }
    private void insertRoot(int data) {
        root = new TreeNode(data);
        insertNodes(root);
    }

    private void insertNodes(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }

        System.out.println("Enter left or right of " + root.val);
        String dir = in.nextLine();
        System.out.println("Enter data: ");
        int data = in.nextInt();
        if("left".equals(dir)) {
            root.left = new TreeNode(data);
            insertNodes(root.left);
        }
        else {
            root.right = new TreeNode(data);
            insertNodes(root.right);
        }
    }

    /*
     * Node Left Right
     */
    void preOrder(TreeNode treeNode) {
        if(Objects.isNull(treeNode)) {
            return;
        }

        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /*
     *   Left Node Right
     */
    void inOrder(TreeNode treeNode) {
        if(Objects.isNull(treeNode)) {
            return;
        }

        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }

    /*
     *  Left Right Node
     */
    void postOrder(TreeNode treeNode) {
        if(Objects.isNull(treeNode)) {
            return;
        }

        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    void preOrder(TreeNode treeNode, int ele) {
        if(Objects.isNull(treeNode)) {
            return;
        }
        if(treeNode.val == ele) {
            System.out.println("Found");
            return;
        }
        preOrder(treeNode.left, ele);
        preOrder(treeNode.right, ele);
    }

    int findHeight(TreeNode treeNode, int h) {
        if(Objects.isNull(treeNode)) {
            return -1;
        }

        int lH = findHeight(treeNode.left, h+1);
        int rH = findHeight(treeNode.right, h+1);

        return Math.max(rH, lH) + 1;
    }

    void bfs(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(treeNode);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 1; i <= n; i++) {
                TreeNode ans = queue.poll();
                if(ans != null) {
                    if (ans.left != null) queue.add(ans.left);
                    if (ans.right != null) queue.add(ans.right);

                    System.out.print(ans.val + " ");
                }

            }
            System.out.println();
        }
    }

    public void iterativePreOrder(TreeNode root) {
        if(null == root) return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode rem = st.pop();
            System.out.print(rem.val + " ");

            if(rem.right != null) {
                st.push(rem.right);
            }
            if(rem.left != null) {
                st.push(rem.left);
            }
        }
    }

    public void iterativeInorder(TreeNode treeNode) {
        Stack<TreeNode> st = new Stack<>();

        while (true) {
            if(treeNode != null) {
                st.push(treeNode);
                treeNode = treeNode.left;
            }
            else {
                if(st.isEmpty()) break;
                TreeNode rem = st.pop();
                System.out.print(rem.val + " ");
                treeNode = rem.right;
            }
        }
    }

    public void iterativePostOrder(TreeNode treeNode) {
        if(treeNode == null) return;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(treeNode);
        while(!st1.isEmpty()) {
            TreeNode rem = st1.pop();
            st2.push(rem);
            if(rem.left != null) st1.push(rem.left);
            if(rem.right != null) st1.push(rem.right);
        }

        while(!st2.isEmpty()) {
            System.out.print(st2.pop().val + " ");
        }
    }

    public void iterativeDFSTravel(TreeNode treeNode, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder) {
        if(treeNode == null) return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(treeNode, 1));

        while (!st.isEmpty()) {
            Pair rem = st.pop();

            if(rem.num == 1) {
                preOrder.add(rem.treeNode.val);

                st.push(new Pair(rem.treeNode, 2));
                if(rem.treeNode.left != null) {
                    st.push(new Pair(rem.treeNode.left, 1));
                }
            } else if (rem.num == 2) {
                inOrder.add(rem.treeNode.val);

                st.push(new Pair(rem.treeNode, 3));
                if(rem.treeNode.right != null)
                    st.push(new Pair(rem.treeNode.right, 1));
            }
            else {
                postOrder.add(rem.treeNode.val);
            }
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        if(root.left != null && root.right != null) {
            return (root.left.val < root.val && root.right.val > root.val);
        }

        if(root.left != null || root.right != null) {
            return false;
        }
        return true;
    }

//    public int sumNumbers(TreeNode root) {
//        return helper(root, "");
//    }
//
//    private int helper3(TreeNode root, String path) {
//        if(root == null) return 0;
//
//        if(root.left == null && root.right == null) {
//            //Leaf Node
//            return Integer.parseInt(path + root.val);
//        }
//
//        return helper(root.left, path + root.val) + helper(root.right, path + root.val);
//    }

    int iMax;
    public int maxPathSum(TreeNode root) {
        iMax = Integer.MIN_VALUE;
        helper3(root, 0);
        return iMax;
    }

    private int helper3(TreeNode root, int iSum) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) {
            return root.val + iSum;
        }

        int left = helper3(root.left, iSum + root.val);
        int right = helper3(root.right, iSum);

        iMax = Math.max(iMax, left + right);

        return left + right;
    }

    String s;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        s = "";
        s = helper3(root, s);
        return s;
    }

    private String  helper3(TreeNode root, String s) {
        if(root == null) {
            s += ",";
            return s;
        }

        s += root.val;
        s = helper3(root.left, s);
        s = helper3(root.right, s);

        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return helper2(data, 0);
    }

    private TreeNode helper2(String data, int idx) {
        if(data.length() == 0) return null;

        String s = data.substring(idx, idx+1);
        if(s.equals(",")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));

        node.left = helper2(data, idx+1);
        node.right = helper2(data, idx+2);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = helperBuild(inorder,postorder);
        return root;
    }

    private TreeNode helperBuild(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;

        int n = postorder.length;
        int val = postorder[n-1];
        int inorderIdx = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) {
                inorderIdx = i;
                break;
            }
        }

        TreeNode node = new TreeNode(val);
        node.left = helperBuild(Arrays.copyOfRange(inorder, 0, inorderIdx), Arrays.copyOfRange(postorder, 0, inorderIdx));
        node.right = helperBuild(Arrays.copyOfRange(inorder, inorderIdx+1, inorder.length), Arrays.copyOfRange(postorder, inorderIdx, postorder.length-1));

        return node;
    }

}
