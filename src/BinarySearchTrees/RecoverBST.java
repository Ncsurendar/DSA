package BinarySearchTrees;

class RecoverBST {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    public void recoverTree(TreeNode root)
    {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last != null)
        {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && middle != null)
        {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        if(root.val < prev.val)
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }
            else last = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println("Original tree (with swapped nodes):");
        printInorder(root);
        System.out.println();

        RecoverBST recover = new RecoverBST();
        recover.recoverTree(root);

        System.out.println("Recovered tree:");
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
