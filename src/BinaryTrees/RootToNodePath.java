package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static boolean getPath(TreeNode root, List<Integer> ans, int x)
    {
        if(root == null) return false;
        ans.add(root.val);
        if(root.val == x) return true;

        if(getPath(root.left, ans, x) || getPath(root.right, ans, x)) return true;
        ans.remove(ans.size() - 1);
        return false;
    }

    public static List<Integer> solve(TreeNode root, int value)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        getPath(root, ans, value);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int targetLeafValue = 7;
        List<Integer> path = solve(root, targetLeafValue);
        System.out.print("Path from root to leaf with value " + targetLeafValue + ": ");
        for (int i = 0; i < path.size(); ++i)
        {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }
    }
}
