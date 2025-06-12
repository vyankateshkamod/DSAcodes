class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Q2{
    public static void main(String[] args) {
        // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});

        ListNode result = addTwoNumbers(l1, l2);

        // Output: 7 -> 0 -> 8
        printList(result);
    }

    // tc : max(l1 , l2)
    // sc : max(l1 , l2) to store result
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        while (t1 != null || t2 != null){
            int sum = carry ;
            if(t1 != null) sum = sum + t1.val ;
            if(t2 != null) sum = sum + t2.val ;

            ListNode newNode = new ListNode(sum % 10) ;
            carry = sum / 10 ;
            curr.next = newNode ;
            curr = curr.next ;

            if(t1 != null) t1 = t1.next ;
            if(t2 != null) t2 = t2.next ;
        } 

        if(carry != 0){
            ListNode newNode = new ListNode(carry) ;
            curr.next = newNode ;
        }

        return dummyNode.next ;
    }

    
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
