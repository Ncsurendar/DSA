package SingleLinkedList;

public class AddTwoNumber {

    static Node addTwoNummber(Node l1, Node l2)
    {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0)
        {
            int digit1 = (l1 != null) ? l1.data : 0;
            int digit2 = (l2 != null) ? l2.data : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(digit);
            current.next = newNode;
            current = current.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = addTwoNummber(l1,l2);

        System.out.print("Result: ");
        while (result != null)
        {
            System.out.print(result.data);
            if (result.next != null)
            {
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }
}
