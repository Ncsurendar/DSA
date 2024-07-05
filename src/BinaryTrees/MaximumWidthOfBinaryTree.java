package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class Pair1{
    TreeNode node;
    int level;
    Pair1(TreeNode node, int level)
    {
        this.level = level;
        this.node = node;
    }
}

public class MaximumWidthOfBinaryTree {

    static int widthOfBinaryTree(TreeNode root)
    {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(root, 0));

        while(!q.isEmpty())
        {
            int size = q.size();
            int min = q.peek().level;
            int first = 0, last = 0;
            for(int i=0; i<size; i++)
            {
                Pair1 currentPair = q.poll();
                int currentindex = currentPair.level - min;
                TreeNode node = currentPair.node;
                if(i == 0) first = currentindex;
                if(i == size - 1) last = currentindex;
                if(node.left != null) q.add(new Pair1(node.left, currentindex * 2 + 1));
                if(node.right != null) q.add(new Pair1(node.right, currentindex * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        int width = widthOfBinaryTree(root);
        System.out.println("Width of the binary tree is: " + width);
    }
}
