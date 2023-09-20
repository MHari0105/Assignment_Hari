package Trees.BinarySearchTree;

public class BST {

    public BST() {

    }

    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;



    public int getHeight(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }



    public boolean isEmpty() {
        return root == null;
    }



    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value)
            node.left = insert(value, node.left);
        if (value > node.value)
            node.right = insert(value, node.right);
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }



    public void populate(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSort(int[] nums) {
        populatedSort(nums, 0, nums.length);
    }

    private void populatedSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populatedSort(nums, start, mid);
        populatedSort(nums, mid+1, end);
    }


    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null)
            return false;
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }



    public void display() {
        display(root, "Root Node:");
    }

    private void display(Node node, String details) {
        if (node == null)
            return;
        System.out.println(details + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

}
