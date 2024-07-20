package StackandQueues;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key)
    {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key)) remove(map.get(key));
        if(map.size() == capacity) remove(tail.prev);
        insert(new Node(key, value));
    }

    private void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node)
    {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

public class LRUCache1 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}
