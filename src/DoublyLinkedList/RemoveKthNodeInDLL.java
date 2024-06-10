package DoublyLinkedList;


public class RemoveKthNodeInDLL {

    static Node convertArr2DLL(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static void printDLL(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static Node RemoveKthNode(Node head, int k)
    {
        if(head == null) return null;
        Node knode = head;
        int count = 0;

        while(knode != null)
        {
            count++;
            if(count == k) break;
            knode = knode.next;
        }

        if(knode == null) return head;

        if(knode.prev != null)
        {
            knode.prev.next = knode.next;
        }
        else
        {
            head = knode.next;
        }
        if(knode.next != null)
        {
            knode.next.prev = knode.prev;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convertArr2DLL(arr);
        head = RemoveKthNode(head, 1);
        printDLL(head);
    }
}
