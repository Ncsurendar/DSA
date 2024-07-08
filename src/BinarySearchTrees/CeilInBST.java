package BinarySearchTrees;

public class CeilInBST {

    static int findCeil(TreeNode root, int key)
    {
        if(root == null) return -1;
        int ceil = -1;
        while(root != null)
        {
            if(root.val == key)
            {
                ceil = root.val;
                return ceil;
            }
            if(key > root.val)
            {
                root = root.right;
            }
            else
            {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key = 9;
        int ceil = findCeil(root, key);
        System.out.println(ceil);
    }
}
