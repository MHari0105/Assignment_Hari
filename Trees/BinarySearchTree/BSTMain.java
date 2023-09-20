package Trees.BinarySearchTree;

public class BSTMain {
    public static void main(String[] args) {

        BST tree = new BST();
        int[] nums1 = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        tree.populate(nums1);
        tree.display();
    }
}
