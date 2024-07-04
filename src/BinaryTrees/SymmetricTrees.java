package BinaryTrees;

public class SymmetricTrees {

    public static boolean isSymmetric(Node root)
    {
        return root == null || helper(root.left, root.right);
    }

    static boolean helper(Node left, Node right)
    {
        if(left == null || right == null) return left == right;
        if(left.data != right.data) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);

        boolean res = isSymmetric(root);
        if (res) {
            System.out.println("This Tree is Symmetrical");
        } else {
            System.out.println("This Tree is NOT Symmetrical");
        }
    }
}
