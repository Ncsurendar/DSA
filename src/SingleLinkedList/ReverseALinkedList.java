package SingleLinkedList;

public class ReverseALinkedList {

    static Node reverseList(Node head)
    {
        Node temp = head;
        Node prev = null;

        while(temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
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

        head = reverseList(head);
        System.out.print("Reversed list: ");
        printList(head);
    }
}
