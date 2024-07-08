package BinarySearchTrees;

public class DeleteANodeinBST {

    public static TreeNode deleteNode(TreeNode root, int key)
    {
        if(root == null ) {
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        else{
            //case 1: leaf node
            if(root.left == null && root.right == null ) {
                return null;
            }
            //case 2 : one child
            if(root.left ==  null){
                return root.right;
            }
            else if(root.right ==  null ) {
                return root.left;
            }
            //case 3 : two children
            TreeNode IS = findInOrderSuccessor(root.right);
            root.val = IS.val;


            root.right = deleteNode(root.right,IS.val);
        }
        return root;
    }

    private static TreeNode findInOrderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
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

        System.out.print("Tree before deletion: ");
        inOrderTraversal(root);
        System.out.println();

        root = deleteNode(root, 3);

        System.out.print("Tree after deletion: ");
        inOrderTraversal(root);
        System.out.println();
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
}
