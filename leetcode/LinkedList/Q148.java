
import java.util.ArrayList;
import java.util.Collections;

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

public class Q148 {

    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(6);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(1);

        // Link nodes: 1 -> 2 -> 3 -> 4
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = sortList(head);
        printList(head);
    }

    // optimal
    // tc : log n (n + n/2)
    // sc : 1
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        if (left == null && right == null) {
            return dummyNode.next;
        }
        if (left == null) {
            temp.next = right;
        }
        if (right == null) {
            temp.next = left;
        }
        return dummyNode.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    // brute
    // tc : n + n log n + n
    // sc : n
    public static ListNode sortList2(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        temp = head;
        for (int num : arr) {
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
