package SingleLinkedList;

public class LengthOfALinkedList {

    static Node constructLL(int[] arr)
    {
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

    static int length(Node head)
    {
        int count = 0;
        Node temp = head;
        while(temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,3,4,5};

        Node head = constructLL(arr);
        System.out.println(length(head));
    }
}
