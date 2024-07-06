package BinaryTrees;

import java.util.*;

public class MinimumTimeTakenToBurnBinaryTree {

    static int minTime(Node root, int target)
    {
        if(root == null) return 0;
        Map<Node, Node> parent = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node targetNode = null;
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.data == target) targetNode = node;
            if(node.left != null)
            {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null)
            {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }

        Set<Node> visited = new HashSet<>();
        q.offer(targetNode);
        visited.add(targetNode);
        int time = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            int flag = 0;

            for(int i=0; i<size; i++)
            {
                Node node = q.poll();
                if(node.left != null && !visited.contains(node.left))
                {
                    q.offer(node.left);
                    visited.add(node.left);
                    flag = 1;
                }
                if(node.right != null && !visited.contains(node.right))
                {
                    q.offer(node.right);
                    visited.add(node.right);
                    flag = 1;
                }
                if(parent.containsKey(node) && !visited.contains(parent.get(node)))
                {
                    q.offer(parent.get(node));
                    visited.add(parent.get(node));
                    flag = 1;
                }
            }

            if(flag == 1) time++;
        }
        return time;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        int target = 4;
        int result = minTime(root, target);
        System.out.println(result);
    }
}
