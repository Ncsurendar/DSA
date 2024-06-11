package DoublyLinkedList;

public class RemoveDuplicatesFromALinkedList {

    static Node removeDuplicates(Node head)
    {
        Node temp = head;
        while(temp != null && temp.next != null)
        {
            Node nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data)
            {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }

        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.prev = head.next.next.next;

        // Print original list
        System.out.println("Original List:");
        printList(head);

        head = removeDuplicates(head);
        System.out.println("Updated List after removing duplicates:");
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
