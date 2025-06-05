import java.util.HashSet ;
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
public class Q141 {
    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create a cycle: -4 -> 2
        node4.next = node2; // cycle here

        // Now node1 is the head of a cyclic list
        System.out.println(hasCycle(head));
        
    }

    // optimal
    // tc : n
    // sc : 1
    public static  boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false ;
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast) return true ;
        }
        return false ;
    }

    //Better
    // tc : n
    // sc : n
    public static boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>() ;
        ListNode curr = head ;
        while(curr != null){
            if(set.contains(curr)) return true ;
            set.add(curr) ;
            curr = curr.next ;
        }
        return false ;
    }
}
