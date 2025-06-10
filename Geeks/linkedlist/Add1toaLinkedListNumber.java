
class Node {

    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Add1toaLinkedListNumber {

    public static void main(String[] args) {
        Node head = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = null;

        head = addOne(head) ;
        printlist(head);
    }

    // Recursive
    // tc : n
    // sc : n (recursive stack space)
    public static Node addOne(Node head){
        int carry = helper(head) ;

        if(carry == 1){
            Node newNode = new Node(1) ;
            newNode.next = head ;
            return newNode ;
        }

        return head ;
    }

    public static int helper(Node temp){
        if(temp == null) return 1 ;
        int carry = helper(temp.next) ;

        temp.data = temp.data + carry ;

        if(temp.data < 10){
            return 0 ;
        }

        temp.data = 0 ;

        return 1 ;
    }

    // Iterative
    // tc : 3n
    // sc : 1
    public static  Node addOne2(Node head) {
        head = reverse(head);
        int carry = 1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 9) {
                temp.data = 0;
                carry = 1;
            } else {
                temp.data = temp.data + carry;
                carry = 0;
                break;

            }

            temp = temp.next;
        }

        head = reverse(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static  Node reverse(Node head) {
        Node back = null;
        Node temp = head;

        while (temp != null) {
            Node front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }

        head = back;
        return head;
    }

    public static void printlist(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
