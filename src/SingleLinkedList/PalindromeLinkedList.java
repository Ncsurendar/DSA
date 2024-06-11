package SingleLinkedList;

public class PalindromeLinkedList {

    static Node reverseList(Node head)
    {
        Node temp = head;
        Node prev = null;

        while(temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node newHead = reverseList(slow.next);
        Node first = head;
        Node second = newHead;
        while(second != null)
        {
            if(first.data != second.data)
            {
                reverseList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        boolean ans = isPalindrome(head);
        System.out.println(ans);

    }
}
