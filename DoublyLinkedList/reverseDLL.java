import java.util.Stack ;
class Node {

    Node prev;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

public class reverseDLL {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        Node head = convert(arr);
        print(head);
        head = reverse(head);
        print(head);
    }

    // optimal
    // tc : n
    public static Node reverse(Node head){
        Node back = null ;
        Node curr = head ;
        while(curr != null){
            back = curr.prev ;
            curr.prev = curr.next ;
            curr.next = back ;
            curr = curr.prev ;
        }
        head = back.prev ;
        return head ;
    }
    //brute
    // tc : 2n
    // sc : n
    public static Node reverse2(Node head) {
        Node curr = head ;
        Stack<Integer> stack = new Stack<>() ;
        while(curr != null){
            stack.push(curr.data) ;
            curr = curr.next ;
        }
        curr = head ;
        while(curr != null){
            curr.data = stack.pop() ;
            curr = curr.next ;
        }
        return head ;
    }

    public static Node convert(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
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
