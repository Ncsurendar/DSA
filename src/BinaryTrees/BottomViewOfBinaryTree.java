package BinaryTrees;

import java.util.*;

public class BottomViewOfBinaryTree {

    static List<Integer> bottomView(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair<Node,Integer >> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));
        while(!q.isEmpty())
        {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            mpp.put(line, node.data);
            if(node.left != null) q.add(new Pair<>(node.left, line-1));
            if(node.right != null) q.add(new Pair<>(node.right, line+1));
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
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

        List<Integer> bottomView = bottomView(root);
        System.out.println("Bottom View Traversal: ");
        for(int node : bottomView)
        {
            System.out.print(node + " ");
        }
    }
}
