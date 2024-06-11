package DoublyLinkedList;

import java.util.ArrayList;

public class FindPairsWithGivenSum {

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        Node left = head;
        Node right = temp;

        while(left.data < right.data)
        {
            int sum = left.data + right.data;
            if (sum == target)
            {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(left.data);
                ans.add(right.data);
                res.add(ans);
                left = left.next;
                right = right.prev;
            }
            else if(sum > target) right = right.prev;
            else left = left.next;
        }

        return res;
    }

    public static void main(String[] args) {
        // Create the doubly linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;


        System.out.println("Original List:");
        printList(head);


        int target = 5;
        ArrayList<ArrayList<Integer>> pairs = findPairsWithGivenSum(target, head);


        System.out.println("Pairs with sum " + target + ":");
        for (ArrayList<Integer> pair : pairs)
        {
            System.out.println(pair.get(0) + ", " + pair.get(1));
        }
    }

    static void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
