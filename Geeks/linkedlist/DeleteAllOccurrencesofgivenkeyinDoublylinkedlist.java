
class Node {

    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }

    Node(Node prev , int data , Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class DeleteAllOccurrencesofgivenkeyinDoublylinkedlist {

    public static void main(String[] args) {
        Node head  = new Node(10);
        Node node2 = new Node(2) ;
        Node node3 = new Node(10) ;
        Node node4 = new Node(4) ;

        head.next = node2;

        node2.prev = head;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node4;

        node4.prev = node3;

        head = deleteAllOccurOfX(head, 10) ;
        print(head);
        
    }

    // tc : n
    // sc : 1
    static Node deleteAllOccurOfX(Node head, int x) {

        while (head != null && head.data == x) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }

        Node curr = head;
        while (curr != null) {

            if (curr.data == x) {
                Node back = curr.prev;
                Node front = curr.next;

                back.next = front;
                if (front != null) {
                    front.prev = back;
                }
            }
            curr = curr.next;
        }

        return head;
    }

    public static void print(Node head) {
        Node curr = head;
        System.out.println();
        while (curr != null) {
            System.out.print(curr.data + " <--> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println();
    }
}
