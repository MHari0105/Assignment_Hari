package Trees.BinaryTree;

import java.util.Scanner;

public class BinaryTreeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        tree.prettyDisplay();
    }
}
