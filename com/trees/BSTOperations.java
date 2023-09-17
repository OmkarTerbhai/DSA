package com.trees;

import java.util.Objects;

/**
 * BST Primitive Operations:-
 *  1. Insert
 *  2. Delete
 *      a. Delete Leaf Node
 *      b. Delete Node with one child
 *      c. Delete Node with two children
 */
public class BSTOperations {
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

    public  void init() {
        root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(12);

        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(8);

        root.right.right = new Node(13);
    }

    /**
     * Insert Node in leaf in a BST.
     * Traverse until you find the right position.
     * i.e. Traverse till node == null.
     * @param node
     */
    Node insert(Node node, int data) {
        if(Objects.isNull(node)) {
            return new Node(data);
        }

        /*Current node data is greater than the new data
        * Therefore, go left to insert the node
        * */
        if(node.data > data) {
            node.left = insert(node.left, data);
        }
        /*Current node data is lesser than new node data
        * Therefore, go right to insert the node
        */
        else if (node.data < data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    /**
     *  Delete the leaf node.
     */
    Node delete(Node node, int data) {
        if(Objects.equals(node.data, data)) {
            if(Objects.nonNull(node.right) || Objects.nonNull(node.left)) {
                //To be deleted node has a single child
                Node toBeReplaced = Objects.isNull(node.right) ? node.left : node.right;
                int temp = node.data;
                node.data = toBeReplaced.data;
                toBeReplaced.data = temp;

                toBeReplaced = null;
                if(Objects.isNull(node.right)) {
                    node.left = null;
                }
                else {
                    node.right = null;
                }
                return node;
            }

            if(Objects.nonNull(node.right) && Objects.nonNull(node.left)) {
                Node toBeReplaced = node.right;
                int temp = node.data;
                node.data = toBeReplaced.data;
                toBeReplaced.data = temp;

                toBeReplaced = null;
                node.right = null;
                return node;
            }
            return null;
        }

        /*Current node data is greater than the new data
         * Therefore, go left to insert the node
         * */
        if(node.data > data) {
            node.left = delete(node.left, data);
        }
        /* Current node data is lesser than new node data
         * Therefore, go right to insert the node
         */
        else if (node.data < data) {
            node.right = delete(node.right, data);
        }

        return node;
    }

    /**
     *
     * @param node
     */


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
    public static void main(String[] args) {
        BSTOperations bst = new BSTOperations();
        bst.init();

        System.out.println("-----------------------Printing BST Inorder-------------------");
        bst.inOrder(root);

        System.out.println();
        System.out.println("-----------------------Delete in BST--------------------------");
        bst.delete(root, 7);

        System.out.println();
        System.out.println("-----------------------Displaying after delete----------------");
        bst.inOrder(root);
    }
}
