package ca.ljdelavega.javapractice;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        // Create a sample binary tree
        BinaryTree tree = new BinaryTree(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);

        // calculate the height.
        System.out.println(tree.heightOfBinaryTree(tree.getRoot()));
    }





}
