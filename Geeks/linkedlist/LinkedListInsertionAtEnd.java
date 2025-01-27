

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

public class LinkedListInsertionAtEnd {
    public static void main(String[] args) {
        Node head = new Node(1) ;
        head.next = new Node(2) ;
        head.next.next = new Node(1) ;
        
        printlist(head);
        insertAtEnd(head, 6) ;
        printlist(head);
    }

    static void printlist(Node head){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    static Node insertAtEnd(Node head, int x) {
        if(head==null){
            Node newList = new Node(x);
            return newList ;
        }
        Node crr = head ;

        while(crr.next!=null){
            crr = crr.next ;
            
        }
        Node newNode = new Node(x) ;
        
        crr.next = newNode ; 
        newNode.next = null ;
        return head ;
    }
}
