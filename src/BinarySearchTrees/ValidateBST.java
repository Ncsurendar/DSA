package BinarySearchTrees;

public class ValidateBST {

    static boolean validate(TreeNode root)
    {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean helper(TreeNode root, long min, long max)
    {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        boolean ans = validate(root);
        System.out.println(ans);
    }
}
