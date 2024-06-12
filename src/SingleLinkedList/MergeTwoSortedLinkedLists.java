package SingleLinkedList;

public class MergeTwoSortedLinkedLists {

    static Node mergeTwoLists(Node list1, Node list2)
    {
        Node dummy = new Node(0);
        Node temp = dummy;
        Node l1 = list1;
        Node l2 = list2;

        while(l1 != null && l2 != null)
        {
            if(l1.data < l2.data)
            {
                temp.next = l1;
                l1 = l1.next;
            }
            else
            {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) temp.next = l1;
        else temp.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Node result = mergeTwoLists(list1, list2);
        while (result != null)
        {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
