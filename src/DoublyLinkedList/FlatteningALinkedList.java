package DoublyLinkedList;

class Node1 {
    int data;
    Node1 next;
    Node1 bottom;
    Node1(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}

public class FlatteningALinkedList {

    public static Node1 flatten(Node1 head)
    {
        if (head == null || head.next == null) return head;
        Node1 mergedHead = flatten(head.next);
        head = merge(head, mergedHead);
        return head;
    }

    public static Node1 merge(Node1 list1, Node1 list2)
    {
        Node1 dummyNode = new Node1(-1);
        Node1 res = dummyNode;
        while (list1 != null && list2 != null)
        {
            if (list1.data < list2.data)
            {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            }
            else
            {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        if (list1 != null) res.bottom = list1;
        else res.bottom = list2;

        return dummyNode.bottom;
    }

    public static void main(String[] args) {
        Node1 head = new Node1(5);
        head.bottom = new Node1(7);
        head.bottom.bottom = new Node1(8);
        head.bottom.bottom.bottom = new Node1(30);

        head.next = new Node1(10);
        head.next.bottom = new Node1(20);

        head.next.next = new Node1(19);
        head.next.next.bottom = new Node1(22);
        head.next.next.bottom.bottom = new Node1(50);

        head.next.next.next = new Node1(28);
        head.next.next.next.bottom = new Node1(35);
        head.next.next.next.bottom.bottom = new Node1(40);
        head.next.next.next.bottom.bottom.bottom = new Node1(45);

        Node1 flattenedList = flatten(head);
        Node1 temp = flattenedList;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
    }
}
