package BinaryTrees;

public class DiameterOfABinaryTree {

    static int diameterOfBinaryTree(Node root)
    {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    static int height(Node root, int[] diameter)
    {
        if(root == null) return 0;
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        int diameter = diameterOfBinaryTree(root);
        System.out.println("The diameter of the binary tree is: " + diameter);
    }
}
