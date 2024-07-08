package BinarySearchTrees;

public class InsertIntoABST {

    public static TreeNode insertIntoBST(TreeNode root, int val)
    {
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        while(true)
        {
            if(curr.val <= val)
            {
                if(curr.right != null) curr = curr.right;
                else
                {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            else
            {
                if(curr.left != null) curr = curr.left;
                else
                {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
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

        insertIntoBST(root, 7);
        inOrderTraversal(root);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
}
