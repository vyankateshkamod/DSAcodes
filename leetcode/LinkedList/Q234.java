import java.util.Stack ;
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
public class Q234{
    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        // Link nodes: 1 -> 2 -> 2 -> 1
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(head));
        
    }

    // Optimal 
    // tc : 4n
    // sc : 1
    public static  boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true ;
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        ListNode newHead = reverse(slow.next) ;
        // compare 
        ListNode back = head ;
        ListNode front = newHead ;
        while(front != null){
            if(back.val != front.val){
                reverse(newHead) ;
                return false ;
            }
            back = back.next ;
            front = front.next ;
        }
        reverse(newHead) ;
        return true ;
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head ;
        }
        ListNode back = null ;
        ListNode curr = head ;
        ListNode front = null ;
        while(curr != null){
            front = curr.next ;
            curr.next = back ;
            back = curr ;
            curr = front ;
        }
        ListNode newHead = back ;
        return newHead ;
    }

    // better 
    // tc : 2n
    // sc : n
    public static  boolean isPalindrome2(ListNode head) {
        Stack<Integer> stack = new Stack<>() ;
        ListNode temp = head ;
        while(temp != null){
            stack.push(temp.val) ;
            temp = temp.next ;
        }
        
        temp = head ;
        while(temp != null){
            if(stack.peek() != temp.val){
                return false ;
            }
            stack.pop() ;
            temp = temp.next ;
        }
        return true ;
    }
}
