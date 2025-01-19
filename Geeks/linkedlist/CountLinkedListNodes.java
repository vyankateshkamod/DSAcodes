public class CountLinkedListNodes {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        printlist(head);
        System.out.println(getCount(head));

    }

    public static int getCount(Node head) {
        
        Node curr = head ;
        int count = 0 ;
        while(curr!=null){
            count++; 
            curr=curr.next ;
        }
        return count ;
    }

    static void printlist(Node head){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}