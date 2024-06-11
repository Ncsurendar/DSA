package SingleLinkedList;

public class SortALinkedList {

    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        Node l1 = sortList(head);
        Node l2 = sortList(slow);
        return merge(l1, l2);
    }

    static Node merge(Node l1, Node l2) {
        Node l = new Node(0);
        Node p = l;

        while (l1 != null && l2 != null)
        {
            if (l1.data < l2.data)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return l.next;
    }

    public static void main(String[] args) {

        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        Node sortedHead = sortList(head);
        printList(sortedHead);
    }
    public static void printList(Node head)
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data);
            if (current.next != null)
            {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

}
