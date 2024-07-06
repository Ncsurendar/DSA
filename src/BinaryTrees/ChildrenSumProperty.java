package BinaryTrees;

public class ChildrenSumProperty {

    static void changeTree(TreeNode root)
    {
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.val;
        if(root.right != null) child += root.right.val;

        if(child >= root.val) root.val = child;
        else
        {
            if(root.left != null) root.left.val = root.val;
            else if(root.right != null) root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left != null) total += root.left.val;
        if(root.right != null) total += root.right.val;

        if(root.left != null || root.right != null) root.val = total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.print("Binary Tree before modification: ");
        TreeTraversal.inorderTraversal(root);
        System.out.println();

        changeTree(root);

        System.out.print("Binary Tree after Children Sum Property: ");
        TreeTraversal.inorderTraversal(root);
        System.out.println();
    }
}

class TreeTraversal {
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}
