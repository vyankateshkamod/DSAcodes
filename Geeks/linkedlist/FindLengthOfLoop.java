import java.util.HashMap ;
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

public class FindLengthOfLoop {

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create a cycle: -4 -> 2
        node4.next = node2; // cycle here

        // Now node1 is the head of a cyclic list
        System.out.println(countNodesinLoop(head));

    }

    // optimal
    // tc : n + k
    // sc : 1
    public static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int cnt = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // loop detected
                slow = slow.next;
                while (slow != fast) {  // counting no of nodes in cycle
                    cnt++;
                    slow = slow.next;
                }
                return cnt;
            }
        }
        return 0; // no loop
    }

    // better
    // tc : n + k
    // sc : n
    public static  int countNodesinLoop2(Node head) {
        Node temp = head;
        int cnt = 1;
        HashMap<Node, Integer> map = new HashMap<>();
        while (temp != null && temp.next != null) {
            if (map.containsKey(temp)) {
                int val = map.get(temp);
                return cnt - val;
            }
            map.put(temp, cnt);
            cnt++;
            temp = temp.next;
        }
        return 0; // no loop
    }
}
