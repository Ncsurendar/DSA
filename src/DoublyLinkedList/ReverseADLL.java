package DoublyLinkedList;

public class ReverseADLL {

    static Node convertArr2DLL(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }

    public static Node reverseDLL(Node  head)
    {
        if(head == null || head.next == null) return head;
        Node last = null;
        Node current = head;
        while(current != null)
        {
            last = current.prev;
            current.prev = current.next;
            current.next = last;

            current = current.prev;
        }
        head = last.prev;

        return head;
    }

    static void printDLL(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convertArr2DLL(arr);
        System.out.print("Original DLL: ");
        printDLL(head);
        head = reverseDLL(head);
        System.out.print("Reversed DLL: ");
        printDLL(head);
    }
}
