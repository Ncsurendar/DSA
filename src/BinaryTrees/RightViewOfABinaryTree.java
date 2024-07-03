package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfABinaryTree {

    public static List<Integer> rightsideView(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        recursionRight(root, 0, ans);
        return ans;
    }

    static void recursionRight(Node root, int level, List<Integer> ans)
    {
        if(root == null) return;
        if(ans.size() == level) ans.add(root.data);
        recursionRight(root.right, level+1, ans);
        recursionRight(root.left, level+1, ans);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<Integer> rightView = rightsideView(root);
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
