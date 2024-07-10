package BinarySearchTrees;

public class InorderSuccessor {

    static TreeNode inorderSuccessor(TreeNode root, TreeNode target)
    {
        TreeNode successor = null;
        while(root != null)
        {
            if(target.val >= root.val) root = root.right;
            else
            {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(12);

        TreeNode target = root.left.right;
        TreeNode successor = inorderSuccessor(root, target);
        if (successor != null) {
            System.out.println("Inorder Successor of " + target.val + " is " + successor.val);
        } else {
            System.out.println("Inorder Successor of " + target.val + " does not exist");
        }
    }
}
