package SingleLinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public static Node mergeKLists(Node[] lists)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Node head : lists)
        {
            while(head != null)
            {
                pq.add(head.data);
                head = head.next;
            }
        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(!pq.isEmpty())
        {
            int val = pq.poll();
            Node newNode = new Node(val);
            temp.next = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node[] lists = new Node[]{list1, list2, list3};
        Node mergedList = mergeKLists(lists);
        printList(mergedList);
    }

    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
