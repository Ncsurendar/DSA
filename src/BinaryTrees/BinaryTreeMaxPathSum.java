package BinaryTrees;

public class BinaryTreeMaxPathSum {

    static int maxPathSum(Node root)
    {
        int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0];
    }

    static int findMaxPathSum(Node root, int[] maxi)
    {
        if(root == null) return 0;
        int left = Math.max(0, findMaxPathSum(root.left, maxi));
        int right = Math.max(0, findMaxPathSum(root.right, maxi));
        maxi[0] = Math.max(maxi[0], left + right + root.data);
        return Math.max(left, right) + root.data;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
