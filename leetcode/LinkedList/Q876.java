


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

public class Q876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        printList(head);

        head = middleNode(head);

        printList(head);
    }

    public static  ListNode middleNode(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        head = slow ;
        return head ;
    }

    // tc : n + (n/2)
    public static ListNode middleNode2(ListNode head) {
        ListNode curr = head ; 
        int cnt = 0 ;
        while(curr != null){
            curr = curr.next ;
            cnt++ ;
        }
        int mid = (cnt / 2) + 1 ;
        curr = head ;
        cnt = 1 ;
        while(mid != cnt){
            curr = curr.next ;
            cnt++ ;
        }
        head = curr ;
        return head ;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
