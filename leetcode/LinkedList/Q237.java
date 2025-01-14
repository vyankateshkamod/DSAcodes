//237. Delete Node in a Linked List
// last node will node given for delete 
// head is not given
// ignore the exceptions but working on leetcode 

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

public class Q237 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        printList(head);

        deleteNode(new ListNode(2));

        printList(head);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void deleteNode(ListNode node) {

        ListNode prev = null ;

        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }

        prev.next = null ;
    }
}
