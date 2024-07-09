package BinarySearchTrees;

public class KthLargestAndSmallestElementInABST {

    public static void reverseInorder(TreeNode root, int[] count, int k, int[] largest)
    {
        if(root == null || count[0] >= k) return;
        reverseInorder(root.right, count, k, largest);
        count[0]++;
        if(count[0] == k)
        {
            largest[0] = root.val;
            return;
        }
        reverseInorder(root.left, count, k, largest);
    }

    public static void inorder(TreeNode root, int[] count, int k ,int[] smallest)
    {
        if(root == null || count[0] >= k) return;
        inorder(root.left, count, k, smallest);
        count[0]++;
        if(count[0] == k)
        {
            smallest[0] = root.val;
            return;
        }
        inorder(root.right, count, k, smallest);
    }

    public static int[] findKth(TreeNode root, int k)
    {
        int[] smallest = new int[]{Integer.MIN_VALUE};
        int[] largest = new int[]{Integer.MIN_VALUE};
        int[] count = new int[]{0};

        //To Calculate the Kth Smallest Value We are going to do Inorder Traversal
        inorder(root, count, k, smallest);

        //To Calculate the Kth Largest Value we are going to do reverse Inorder Traversal
        count[0] = 0;
        reverseInorder(root, count, k, largest);

        return new int[]{smallest[0], largest[0]};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        int k = 3;
        int[] kthElements = findKth(root, k);

        System.out.println("Kth smallest element: " + kthElements[0]);
        System.out.println("Kth largest element: " + kthElements[1]);
    }
}
