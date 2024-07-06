package BinaryTrees;

public class CountCompleteTreeNodes {

    static int countNodes(TreeNode root)
    {
        if(root == null) return 0;
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if(lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int findLeftHeight(TreeNode node)
    {
        int height = 0;
        while(node != null)
        {
            height++;
            node = node.left;
        }
        return height;
    }

    static int findRightHeight(TreeNode node)
    {
        int height = 0;
        while(node != null)
        {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int totalNodes = countNodes(root);
        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
    }
}
