package BinaryTrees;

public class SameTree {

    static boolean isIdentical(Node root1, Node root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.data != root2.data) return false;

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);


        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        if (isIdentical(root1, root2)) System.out.println("The binary trees are identical.");
        else System.out.println("The binary trees are not identical.");
    }
}
