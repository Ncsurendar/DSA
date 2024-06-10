package DoublyLinkedList;

public class InsertionAtKthPosition {

    static Node convertArr2DLL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }

    static Node insertKthNode(Node head, int k, int data) {
        Node newNode = new Node(data);
        if (k <= 0) return head;

        if (k == 1)
        {
            newNode.next = head;
            if (head != null)
            {
                head.prev = newNode;
            }
            head = newNode;
            return head;
        }

        Node current = head;
        int count = 0;

        while (current != null)
        {
            count++;
            if(count == k) break;
            current = current.next;
        }

        if (current == null) return head;


        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null)
        {
            current.next.prev = newNode;
        }
        current.next = newNode;

        return head;
    }

    static void printDLL(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
            int[] arr = {12, 5, 8, 7};
            Node head = convertArr2DLL(arr);
            head = insertKthNode(head, 1, 10);  // Insert 10 at position 1
            printDLL(head);

    }
}
