package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    static boolean isLeaf(Node root)
    {
        return root.left == null && root.right == null;
    }

    static void addLeftBoundary(Node root, List<Integer> ans)
    {
        Node curr = root.left;
        while(curr != null)
        {
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    static void addLeaves(Node root, List<Integer> ans)
    {
        if(isLeaf(root))
        {
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null) addLeaves(root.right, ans);
    }

    static void addRightBoundary(Node root, List<Integer> ans)
    {
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr != null)
        {
            if (!isLeaf(curr)) st.push(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        while(!st.isEmpty()) ans.add(st.pop());
    }

    public static List<Integer> printBoundary(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        if(!isLeaf(root)) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = printBoundary(root);
        System.out.print("Boundary Traversal: ");
        printResult(result);
    }

    static void printResult(List<Integer> result)
    {
        for(int val : result)
        {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
