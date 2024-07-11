package BinarySearchTrees;

public class LargestBSTSubTree {
    static class SubtreeInfo {
        int size;  // Size of the largest BST
        int min;   // Minimum value in the subtree
        int max;   // Maximum value in the subtree
        boolean isBST;  // Whether the subtree is a BST

        SubtreeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return findLargestBST(root).size;
    }

    private SubtreeInfo findLargestBST(TreeNode node) {
        if (node == null) {
            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        SubtreeInfo left = findLargestBST(node.left);
        SubtreeInfo right = findLargestBST(node.right);

        // Check if current node is a BST
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);
            return new SubtreeInfo(size, min, max, true);
        }

        return new SubtreeInfo(Math.max(left.size, right.size), 0, 0, false);
    }

    public static void main(String[] args) {
        LargestBSTSubTree tree = new LargestBSTSubTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);

        System.out.println("Size of the largest BST is " + tree.largestBSTSubtree(root));
    }
}
