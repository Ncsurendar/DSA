package SingleLinkedList;

public class RemoveNthNodeFromEndOfList {

    static Node removeNthFromEnd(Node head, int n)
    {
        Node start = new Node(0);
        start.next = head;
        Node fast = start;
        Node slow = start;
        for(int i=1; i<=n; i++)
        {
            fast = fast.next;
        }

        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static void printList(Node head)
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original list: ");
        printList(head);

        head = removeNthFromEnd(head, 5);
        System.out.print("Modified list: ");
        printList(head);
    }
}
