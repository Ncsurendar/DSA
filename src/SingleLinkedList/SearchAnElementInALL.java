package SingleLinkedList;

public class SearchAnElementInALL {

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

    static boolean searchKey(Node head,int val)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,3,4,5};
        int target = 5;
        Node head = constructLL(arr);
        System.out.println(searchKey(head,target));
    }
}
