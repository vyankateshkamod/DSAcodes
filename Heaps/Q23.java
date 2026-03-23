
import java.util.PriorityQueue;


public class Q23 {

    public static void main(String[] args) {
        int[][] input = {
            {1, 4, 5},
            {1, 3, 4},
            {2, 6}
        };

        ListNode[] lists = new ListNode[input.length];

        // Create linked lists
        for (int i = 0; i < input.length; i++) {
            lists[i] = createList(input[i]);
        }

        // Call function
        ListNode result = mergeKLists(lists);

        // Print result
        printList(result);
    }

    // optimal
    // tc : n log k
    // sc : k
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> Q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                Q.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!Q.isEmpty()) {
            ListNode minNode = Q.poll();
            temp.next = minNode;
            temp = temp.next;
            if (minNode.next != null) {
                Q.add(minNode.next);
            }
        }

        return dummy.next;
    }


    // Helper to create list from array
    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for (int x : arr) {
            temp.next = new ListNode(x);
            temp = temp.next;
        }
        return dummy.next;
    }

    // Helper to print list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
