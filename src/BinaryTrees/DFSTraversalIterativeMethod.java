package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class DFSTraversalIterativeMethod {

    public static List<List<Integer>> preInPostTraversal(TreeNode root)
    {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null) return new ArrayList<>();

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));

        while(!st.isEmpty())
        {
            Pair<TreeNode, Integer> it = st.pop();
            if (it.getValue() == 1)
            {
                pre.add(it.getKey().val);
                it.setValue(2);
                st.push(it);
                if(it.getKey().left != null)
                {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            else if (it.getValue() == 2)
            {
                in.add(it.getKey().val);
                it.setValue(3);
                st.push(it);
                if (it.getKey().right != null)
                {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            }

            else
            {
                post.add(it.getKey().val);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> pre, in, post;
        List<List<Integer>> traversals = preInPostTraversal(root);

        pre = traversals.get(0);
        in = traversals.get(1);
        post = traversals.get(2);

        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }

    public static void printList(List<Integer> list) {
        for(int num : list)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
