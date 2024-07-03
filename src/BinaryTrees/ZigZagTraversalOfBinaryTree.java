package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalOfBinaryTree {

    static List<List<Integer>> ZigZagLevelOrder(Node root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                Node node = q.poll();
                if(flag) row.add(node.data);
                else row.add(0, node.data);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            flag = !flag;
            ans.add(row);
        }
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

        List<List<Integer>> result = ZigZagLevelOrder(root);
        printResult(result);
    }

    static void printResult(List<List<Integer>> result)
    {
        for(List<Integer> row : result)
        {
            for(int val : row)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
