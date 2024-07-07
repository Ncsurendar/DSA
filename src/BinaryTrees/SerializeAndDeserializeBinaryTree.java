package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode root)
    {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode currNode = q.poll();
            if(currNode == null) sb.append("#,");
            else
            {
                sb.append(currNode.val).append(",");
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }

        return sb.toString();
    }

    public static TreeNode deserialize(String data)
    {
        if(data == null || data.isEmpty()) return null;
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while(!q.isEmpty())
        {
            TreeNode currNode = q.poll();
            if(!values[i].equals("#"))
            {
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                currNode.left = leftChild;
                q.offer(leftChild);
            }
            i++;
            if(!values[i].equals("#"))
            {
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                currNode.right = rightChild;
                q.offer(rightChild);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized tree: " + serialized);

        TreeNode deserializedRoot = deserialize(serialized);
        System.out.println("Deserialized tree (pre-order traversal): ");
        printPreOrder(deserializedRoot);
    }

    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            System.out.print("# ");
            return;
        }
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
