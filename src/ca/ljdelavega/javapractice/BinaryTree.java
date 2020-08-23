package ca.ljdelavega.javapractice;

/**
 * Binary Tree data structure
 */
public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTree(int value) {
        this.root = new BinaryTreeNode(value);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    /**
     * Calculate the height of a binary tree
     * The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
     * The height of a binary tree with a single node is taken as zero.
     * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
     * @param node The root node of the binary tree
     * @return
     */
    public int heightOfBinaryTree(BinaryTreeNode node) {
        // return 0 if root is null or if tree is a single node.
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return 0;
        } else {
            // recursively compute the height of each subtree
            int heightLeft = heightOfBinaryTree(node.getLeft());
            int heightRight = heightOfBinaryTree(node.getRight());
            // return the higher value
            return Math.max(heightLeft + 1, heightRight + 1);
        }
    }

    /**
     * Insert a new binary tree node iteratively.
     * @param value The new value to insert
     */
    public void insert(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        BinaryTreeNode current = root;
        BinaryTreeNode parent;
        while (current != null) {
            parent = current;
            if (value < current.getValue()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                }
            } else if (value > current.getValue()) {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                }
            } else {
                // value already exists.
                return;
            }
        }
    }

    /**
     * Insert a new binary tree node recursively.
     * @param current The current node being processed
     * @param value The value to insert
     * @return The current node
     */
    public BinaryTreeNode insertRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return new BinaryTreeNode(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        } else {
            // value already exists
            return current;
        }

        return current;
    }
}
