package BinaryTrees;

public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root)
    {
        TreeNode curr = root;
        while(curr != null)
        {
            if(curr.left != null)
            {
                TreeNode prev = curr.left;
                while(prev.right != null)
                {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }

    public static void printFlattenTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }

    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
