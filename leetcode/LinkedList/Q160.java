
import java.util.HashMap;


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

public class Q160 {

    public static void main(String[] args) {
        // Create nodes
        ListNode headA = new ListNode(6);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(9);  // 6 -> 2 -> 9 -> 1
        ListNode node4 = new ListNode(1);

        ListNode headB = new ListNode(5);
        ListNode node5 = new ListNode(4);  // 5 -> 4 -> 8 -> node2 of first list
        ListNode node6 = new ListNode(8);

        headA.next = node2;
        node2.next = node3;
        node3.next = node4;

        headB.next = node5;
        node5.next = node6;
        node6.next = node2;

        System.out.print(getIntersectionNode(headA, headB).val);
    }

        // optimal 
    // tc : n1 + n2
    // sc : 1
    public static  ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode t1 = headA ;
        ListNode t2 = headB ;
        while(t1 != t2){
            t1 = t1.next ;
            t2 = t2.next ;
            if(t1 == t2) return t1 ;
            if(t1 == null) t1 = headB ;
            if(t2 == null) t2 = headA ;
        }
        return t1 ;
    }

    // better 
    // tc : n1 + (n2 - n1) + n1
    // sc : 1
    public static  ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        int lenA = 0;
        while (temp != null) {
            lenA++;
            temp = temp.next;
        }

        temp = headB;
        int lenB = 0;
        while (temp != null) {
            lenB++;
            temp = temp.next;
        }

        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            return intersectionPoint(headA, headB, diff);
        } else {
            return intersectionPoint(headB, headA, diff);
        }

    }

    public static  ListNode intersectionPoint(ListNode max, ListNode min, int diff) {
        while (diff != 0) {
            diff--;
            max = max.next;
        }
        while (max != min) {
            max = max.next;
            min = min.next;
        }
        return max;
    }

    // brute 
    // tc : n1 + n2
    // sc : n1
    public static  ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map = new HashMap<>() ;
        ListNode temp = headA ;
        while(temp != null){
            map.put(temp,1) ;
            temp = temp.next ;
        }

        temp = headB ;
        while(temp != null){
            if(map.containsKey(temp)) return temp ;
            temp = temp.next ;
        }
        return null ;
    }
}
