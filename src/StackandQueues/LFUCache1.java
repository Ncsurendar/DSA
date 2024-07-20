package StackandQueues;

import java.util.HashMap;
import java.util.Map;

class CacheNode {
    int key;
    int val;
    CacheNode next;
    CacheNode prev;
    int freq = 1;

    CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    CacheNode head;
    CacheNode tail;

    DoublyLinkedList()
    {
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void addNode(CacheNode node)
    {
        CacheNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    CacheNode removeNode()
    {
        CacheNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    CacheNode removeNode(CacheNode node)
    {
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    boolean isEmpty()
    {
        return head.next == tail;
    }
}

class LFUCache {
    Map<Integer, DoublyLinkedList> freqList = new HashMap<>();
    Map<Integer, CacheNode> map = new HashMap<>();
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 1;
    }

    public int get(int key) {
        if (map.get(key) == null) return -1;
        CacheNode node = map.get(key);
        freqList.get(node.freq).removeNode(node);
        if (freqList.get(node.freq).isEmpty())
        {
            if (minFreq == node.freq)
            {
                minFreq = node.freq + 1;
            }
        }
        node.freq += 1;
        if (freqList.get(node.freq) == null)
        {
            DoublyLinkedList d = new DoublyLinkedList();
            d.addNode(node);
            freqList.put(node.freq, d);
        }
        else
        {
            freqList.get(node.freq).addNode(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        if (map.get(key) != null)
        {
            CacheNode node = map.get(key);
            freqList.get(node.freq).removeNode(node);
            if (freqList.get(node.freq).isEmpty())
            {
                if (minFreq == node.freq) minFreq = node.freq + 1;
            }
            node.freq += 1;
            if (freqList.get(node.freq) == null)
            {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode(node);
                freqList.put(node.freq, d);
            }
            else
            {
                freqList.get(node.freq).addNode(node);
            }
            node.val = value;
        }
        else
        {
            if (map.size() == capacity)
            {
                CacheNode node = freqList.get(minFreq).removeNode();
                map.remove(node.key);
            }
            CacheNode newNode = new CacheNode(key, value);
            map.put(key, newNode);
            if (freqList.get(1) != null)
            {
                freqList.get(1).addNode(newNode);
            }
            else
            {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode(newNode);
                freqList.put(1, d);
            }
            minFreq = 1;
        }
    }
}

public class LFUCache1 {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1); // cache is {1=1}
        lfuCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lfuCache.get(1)); // returns 1
        lfuCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lfuCache.get(2)); // returns -1 (not found)
        System.out.println(lfuCache.get(3)); // returns 3
        lfuCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lfuCache.get(1)); // returns -1 (not found)
        System.out.println(lfuCache.get(3)); // returns 3
        System.out.println(lfuCache.get(4)); // returns 4
    }
}
