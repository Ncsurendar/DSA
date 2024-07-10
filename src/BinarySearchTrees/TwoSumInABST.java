package BinarySearchTrees;


import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    // reverse --> True --> before
    // reverse --> false --> next
    private boolean reverse;
    public BSTIterator(TreeNode root, boolean isReverse)
    {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        if (!reverse) {
            pushAll(temp.right);
        } else {
            pushAll(temp.left);
        }
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

public class TwoSumInABST {

    static boolean findTarget(TreeNode root, int target)
    {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false); // next
        BSTIterator r = new BSTIterator(root, true);  // before
        int i = l.next();
        int j = r.next();

        while(i < j)
        {
            if(i + j == target) return true;
            else if(i + j < target) i = l.next();
            else j = r.next();
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int target = 9;
        boolean result = findTarget(root, target);
        System.out.println("Target " + target + " exists: " + result);
    }
}
