package DoublyLinkedList;

public class DeleteAllOccurenceOfTheValue {

    static Node deleteAllOccurOfX(Node head, int x)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == x)
            {
                if(temp == head) head = head.next;
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if(nextNode != null) nextNode.prev = prevNode;
                if(prevNode != null) prevNode.next = nextNode;
                temp = nextNode;
            }
            else
            {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original List:");
        printList(head);

        head = deleteAllOccurOfX(head, 2);
        System.out.println("Updated List after deleting all occurrences of 2:");
        printList(head);
    }

    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
