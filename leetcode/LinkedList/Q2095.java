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

public class Q2095 {

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

        head = deleteMiddle(head);
        printList(head);
    }

    // optimal 
    // tc : n/2
    public static  ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null ;
        ListNode slow = head ;
        ListNode fast = head.next.next ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        slow.next = slow.next.next ;
        return head ;
    }

    // better
    // tc : n + n/2
    public static  ListNode deleteMiddle2(ListNode head) {
        if(head == null || head.next == null) return null ;
        ListNode temp = head ;
        int len = 0 ;
        while(temp != null){
            len++ ;
            temp = temp.next;
        }
        int mid = (len / 2);
        temp = head ;
        while(temp != null){
            mid-- ;
            if(mid == 0) break ;
            temp = temp.next ;
        }
        ListNode delNode = temp.next ;
        temp.next = temp.next.next ;
        delNode.next = null ;
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
