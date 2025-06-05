import java.util.HashMap ;
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
public class Q142 {
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
        System.out.println(detectCycle(head).val);
        
    }

    // optimal
    // tc : n
    // sc : 1
    public static  ListNode detectCycle(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast){
                slow = head ;
                while(slow != fast){
                    slow = slow.next ;
                    fast = fast.next ;
                }
                return slow ;
            }
        }
        return null ;
    }

    // better
    // tc : n
    // sc : n
    public static ListNode detectCycle2(ListNode head) {
        HashMap<ListNode , Integer> map = new HashMap<>() ;
        while(head != null){
            if(map.containsKey(head)){
                 return head ;
            }
            map.put(head , 1) ;
            head = head.next ;
        }
        return head ;
    }
}
