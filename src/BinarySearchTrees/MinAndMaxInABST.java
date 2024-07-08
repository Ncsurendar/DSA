package BinarySearchTrees;

public class MinAndMaxInABST {

    static int findMin(TreeNode root)
    {
        while(root.left != null) root = root.left;
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int min = findMin(root);
        System.out.println(min);
    }
}
