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

public class Q19 {

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

        head = removeNthFromEnd(head, 2);
        printList(head);
    }

    // Optimal
    // tc : n
    // sc : 1
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head ;
        ListNode fast = head ;
        
        for(int i = 0 ; i < n ; i++){
            fast = fast.next ;
        }

        if(fast == null) return head.next ;  // if n is equl to length
        while(fast.next != null){
            slow = slow.next ;
            fast = fast.next ;
        }
        ListNode delNode = slow.next ;
        slow.next = slow.next.next ;
        delNode.next = null ;
        return head;
    }

    // better
    // tc : 2n
    // sc : 1
    public static  ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if(len == n){
            ListNode newHead = head.next ;
            return newHead ;
        }

        int res = len - n;
        temp = head;
        while (temp != null) {
            res-- ;
            if(res == 0 ) break ;
            temp = temp.next ;
        }

        ListNode delNode = temp.next ;
        temp.next = temp.next.next ;
        delNode.next = null ;
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
