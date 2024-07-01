package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DepthFirstSearchTraversals {

    public static List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        helperPreOrder(root, ans);
        return ans;

    }

    static void helperPreOrder(TreeNode node, List<Integer> ans)
    {
        if(node == null) return;
        ans.add(node.val);
        helperPreOrder(node.left, ans);
        helperPreOrder(node.right, ans);
    }

    public static List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        helperInOrder(root, ans);
        return ans;
    }

    static void helperInOrder(TreeNode node, List<Integer> ans)
    {
        if(node == null) return;
        helperInOrder(node.left, ans);
        ans.add(node.val);
        helperInOrder(node.right, ans);
    }

    public static List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        helperPostOrder(root, ans);
        return ans;
    }

    static void helperPostOrder(TreeNode node, List<Integer> ans)
    {
        if(node == null) return;
        helperPostOrder(node.left, ans);
        helperPostOrder(node.right, ans);
        ans.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> preorderResult = preorderTraversal(root);
        System.out.println("Preorder: " + preorderResult);

        List<Integer> inorderResult = inorderTraversal(root);
        System.out.println("Inorder: " + inorderResult);

        List<Integer> postorderResult = postorderTraversal(root);
        System.out.println("Postorder: " + postorderResult);
    }
}
