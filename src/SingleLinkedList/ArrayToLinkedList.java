package SingleLinkedList;

class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class ArrayToLinkedList {

    static Node constructLL(int[] arr)
    {
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,3,4,5};

        Node head = constructLL(arr);
        System.out.println(head.data);
    }

}
