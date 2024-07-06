package BinaryTrees;

import java.util.*;

public class PrintAllNodesWithDistanceOfK {

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
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

        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currentLevel = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            if(currentLevel != k)
            {
                for(int i=0; i<size; i++)
                {
                    TreeNode node = q.poll();
                    if(node.left != null && !visited.contains(node.left))
                    {
                        q.offer(node.left);
                        visited.add(node.left);
                    }
                    if(node.right != null && !visited.contains(node.right))
                    {
                        q.offer(node.right);
                        visited.add(node.right);
                    }
                    if(parent.containsKey(node) && !visited.contains(parent.get(node)))
                    {
                        q.offer(parent.get(node));
                        visited.add(parent.get(node));
                    }
                }
            }
            else
            {
                for(int i=0; i<size; i++)
                {
                    ans.add(q.poll().val);
                }
                return ans;
            }
            currentLevel++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left;
        int k = 2;
        List<Integer> result = distanceK(root, target, k);
        System.out.println(result);
    }
}
