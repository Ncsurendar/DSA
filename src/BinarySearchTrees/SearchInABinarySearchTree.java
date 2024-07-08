package BinarySearchTrees;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}

public class SearchInABinarySearchTree {

    static TreeNode searchBST(TreeNode root, int target)
    {
        while(root != null && root.val != target)
        {
            root = target < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int target = 6;
        TreeNode result = searchBST(root, target);
        if (result != null) {
            System.out.println("Value " + target + " found in the BST!");
        } else {
            System.out.println("Value " + target + " not found in the BST.");
        }
    }
}
