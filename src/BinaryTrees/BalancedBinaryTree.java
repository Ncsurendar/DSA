package BinaryTrees;

public class BalancedBinaryTree {

    static boolean isBalanced(Node root)
    {
        return dfsHeight(root) != -1;
    }

    static int dfsHeight(Node root)
    {
        if(root == null) return 0;
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        if (isBalanced(root))
        {
            System.out.println("The tree is balanced.");
        }
        else
        {
            System.out.println("The tree is not balanced.");
        }
    }
}
