import java.util.ArrayList ;
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Q328 {

    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // Link nodes: 1 -> 2 -> 3 -> 4
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = oddEvenList(head);
        printList(head);
    }

    // optimal
    // tc : n
    // sc : 1
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }

    // better 
    // tc : 2n
    // sc : n
    public static  ListNode oddEvenList2(ListNode head) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        ListNode temp = head;
        int index = 1;
        while (temp != null) {
            if (index % 2 == 1) {
                odd.add(temp.val);
            } else {
                even.add(temp.val);
            }
            index++;
            temp = temp.next;
        }

        temp = head;
        for (int num : odd) {
            temp.val = num;
            temp = temp.next;
        }
        for (int num : even) {
            temp.val = num;
            temp = temp.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
