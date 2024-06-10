package SingleLinkedList;

public class OddEvenLinkedList {

    static Node oddevenLL(Node head)
    {
        if(head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(6);
        l1.next.next.next.next.next.next = new Node(7);

        Node head = oddevenLL(l1);

        System.out.print("Result: ");
        while (head != null)
        {
            System.out.print(head.data);
            if (head.next != null)
            {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}
