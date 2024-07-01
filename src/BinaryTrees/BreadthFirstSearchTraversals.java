package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchTraversals {

    static List<List<Integer>> levelOrderTravesal(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        q.add(root);
        while(!q.isEmpty())
        {
            int levels = q.size();
            List<Integer> subLevels = new ArrayList<>();
            for(int i=0; i<levels; i++)
            {
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                subLevels.add(q.remove().val);
            }
            ans.add(subLevels);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<List<Integer>> ans = levelOrderTravesal(root);
        System.out.println("Level Order Traversal: " + ans);
    }
}
