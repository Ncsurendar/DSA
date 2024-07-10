package BinarySearchTrees;

public class ConstructBSTFromPreorder {

    public static TreeNode bstFromPreorder(int[] preorder)
    {
        return helper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public static TreeNode helper(int[] preorder, int bound, int[] i)
    {
        if(i[0] == preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = helper(preorder, root.val, i);
        root.right = helper(preorder, bound, i);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);

        System.out.println("Inorder Traversal of the constructed BST:");
        printInorder(root);
    }

    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

}
