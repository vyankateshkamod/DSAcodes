
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

public class InsertBeforeTail {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        Node head = convert(arr);
        print(head);
        head = Insert(head, 5);
        print(head);
    }

    public static Node Insert(Node head, int x) {
        if (head.next == null) {
            Node newNode = new Node(null, x, head);
            head.prev = newNode;
            head = newNode;
            return head;
        }
        Node front = head;
        Node back = head;
        while (front.next != null) {
            front = front.next;
            back = front.prev;
        }
        Node newNode = new Node(back, x, front);
        back.next = newNode;
        front.prev = newNode;
        return head;
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
