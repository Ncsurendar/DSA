package BinarySearchTrees;

public class FloorInBST {

    static int findFloor(TreeNode root, int key)
    {
        if(root == null) return -1;
        int floor = Integer.MAX_VALUE;
        while(root != null)
        {
            if(root.val == key)
            {
                floor = root.val;
                return floor;
            }
            if(key > root.val)
            {
                floor = root.val;
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key = 7;
        int floor = findFloor(root, key);
        System.out.println(floor);
    }
}
