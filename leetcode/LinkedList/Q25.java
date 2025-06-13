class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q25{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10}; // Example input array

        ListNode head = createLinkedList(arr);
        printLinkedList(head);

        head = reverseKGroup(head,3) ;

        printLinkedList(head);
    }

    // tc : n
    // sc : 1
    public static  ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head ;
        ListNode prevNode = null ;

        while(temp != null){
            ListNode KthNode = getKthNode(temp , k) ;
            if(KthNode == null){
                if(prevNode != null) prevNode.next = temp ;
                break ;
            }

            ListNode nextNode = KthNode.next ;
            KthNode.next = null ;
            reverse(temp) ;
        
            if(prevNode != null) prevNode.next = KthNode ;
            prevNode = temp ;

            if(temp == head){
                head = KthNode ;
            }
        
            temp = nextNode ;
        }

        return head ;
    }

    public static  ListNode getKthNode(ListNode temp ,int k){
        k-- ;
        while(temp != null && k > 0){
            k-- ;
            temp = temp.next ;
        }
        return temp ;
    }

    public static  ListNode reverse(ListNode temp){
        ListNode back = null ;
        
        while(temp != null){
            ListNode front = temp.next ;
            temp.next = back ;
            back = temp ;
            temp = front ;
        }

        return back ;
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
