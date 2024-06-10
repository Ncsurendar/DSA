package DoublyLinkedList;

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data1)
    {
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
}

public class ArrayToDoubleLinkedList {

    static Node convertArr2DLL(int [] arr)
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

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,3,4,5};
        Node head = convertArr2DLL(arr);
        printDLL(head);
    }
}
