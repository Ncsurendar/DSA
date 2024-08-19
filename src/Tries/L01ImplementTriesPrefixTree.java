package Tries;
import java.util.*;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node(){}
    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }
    void put(char ch, Node node)
    {
        links[ch - 'a'] = node;
    }
    Node get(char ch)
    {
        return links[ch - 'a'];
    }
    void setEnd()
    {
        flag = true;
    }
    boolean isEnd()
    {
        return flag;
    }
}

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }
            // Moves to the reference trie
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++)
        {
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        if(node.isEnd()) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0; i<prefix.length(); i++)
        {
            if(!node.containsKey(prefix.charAt(i))) return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

public class L01ImplementTriesPrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        // Search for words in the trie
        System.out.println(trie.search("apple")); // Should return true
        System.out.println(trie.search("app"));   // Should return true
        System.out.println(trie.search("bat"));   // Should return true
        System.out.println(trie.search("ball"));  // Should return false

        // Check for prefixes in the trie
        System.out.println(trie.startsWith("app")); // Should return true
        System.out.println(trie.startsWith("bat")); // Should return true
        System.out.println(trie.startsWith("bake")); // Should return false
    }
}
