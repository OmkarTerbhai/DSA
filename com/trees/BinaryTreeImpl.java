package com.trees;

import java.util.Objects;
import java.util.Scanner;

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

    static Node root;

    public static void main(String[] args) {
        BinaryTreeImpl b = new BinaryTreeImpl();
        b.init();

        System.out.println("-------------Inorder Traversal------------------------");
        b.inOrder(root);
        System.out.println();

        System.out.println("-------------Preorder Traversal-----------------------");
        b.preOrder(root);
        System.out.println();

        System.out.println("-------------Postorder Traversal-----------------------");
        b.postOrder(root);
        System.out.println();

        System.out.println(b.findHeight(root, 0));
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



}
