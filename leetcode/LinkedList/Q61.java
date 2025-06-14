class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q61{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10}; // Example input array

        ListNode head = createLinkedList(arr);
        printLinkedList(head);

        head = rotateRight(head, 3) ;

        printLinkedList(head);
    }

    // tc : 2n
    // sc : 1 
    public static  ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head ;
        int len = 1 ;
        ListNode tail = head ;
        while(tail.next != null){
            len++ ;
            tail = tail.next ;
        }
        if(k % len == 0) return head ;
        k = k % len ;

        tail.next = head ;

        ListNode NthNode = findNthNode(head , len - k) ;

        head = NthNode.next ;
        NthNode.next = null ;

        return head ;
    }

    public static  ListNode findNthNode(ListNode temp , int k){
        int cnt = 1 ;
        while(temp != null){
            if(cnt == k) return temp ;
            cnt++ ;
            temp = temp.next ;
        }
        return temp ;
    }

    // Method to convert array to linked list
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Method to print linked list
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
