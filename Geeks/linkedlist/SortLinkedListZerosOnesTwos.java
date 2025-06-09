
import java.util.HashMap;

class Node {

    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class SortLinkedListZerosOnesTwos {

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(0);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        // Now node1 is the head of a cyclic list
        head = segregate(head);
        printlist(head);

    }

    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node Zero = new Node(-1);
        Node One = new Node(-1);
        Node Two = new Node(-1);

        Node ztail = Zero;
        Node otail = One;
        Node ttail = Two;

        Node temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                ztail.next = temp;
                ztail = ztail.next;
            } else if (temp.val == 1) {
                otail.next = temp;
                otail = otail.next;
            } else if (temp.val == 2) {
                ttail.next = temp;
                ttail = ttail.next;
            }
            temp = temp.next;
        }

        if (One.next != null) {
            ztail.next = One.next;
        } else {
            ztail.next = Two.next;
        }

        otail.next = Two.next;
        ttail.next = null;

        Node newHead = Zero.next;

        return newHead;
    }

    // brute
    // tc : 2n
    // sc : 1
    public static Node segregate2(Node head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i <= 2; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            for (int j = 0; j < map.get(i); j++) {
                temp.val = i;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void printlist(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
