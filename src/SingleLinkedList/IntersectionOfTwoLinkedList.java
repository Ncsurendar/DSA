package SingleLinkedList;

public class IntersectionOfTwoLinkedList {

    static Node getIntersectionPoint(Node headA, Node headB)
    {
        Node temp1 = headA;
        Node temp2 = headB;
        while(temp1 != temp2)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1 == temp2) return temp1;
            if(temp1 == null) temp1 = headB;
            if(temp2 == null) temp2 = headA;
        }

        return temp1;
    }

    public static void main(String[] args) {
        Node intersectingNode = new Node(8);
        intersectingNode.next = new Node(4);
        intersectingNode.next.next = new Node(5);

        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = intersectingNode;

        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = intersectingNode;

        Node intersection = getIntersectionPoint(headA, headB);
        if (intersection != null)
        {
            System.out.println("Intersection at node with value: " + intersection.data);
        }
        else
        {
            System.out.println("No intersection");
        }
    }
}
