//206. Reverse Linked List
package linkedlist ;
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

public class Q206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        printList(head);

        head = reverseList(head);

        printList(head);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseList(ListNode head) {
        // TC = O(n)
        // SC = O(1)
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev ;
    }


    // public static ListNode reverseList(ListNode head) {
    //     // recursion method
    //     // TC = O(n)
    //     // SC = O(n) because it uses stack
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     ListNode a = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return a;
    // }




    // public static ListNode reverseList(ListNode head) {
    // if (head == null)
    // return null;
    // ListNode current = head;
    // int size = 0;
    // while (current != null) {
    // size++;
    // current = current.next;
    // }
    // int[] arr = new int[size];
    // current = head;
    // int j = 0;
    // while (current != null) {
    // arr[j] = current.val;
    // current = current.next;
    // j++;
    // }

    // current = head;
    // for (int i = arr.length - 1; i >= 0; i--) {
    // current.val = arr[i];
    // current = current.next;
    // }
    // return head;
    // }
}