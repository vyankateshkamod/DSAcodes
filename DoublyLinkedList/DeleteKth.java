class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class DeleteKth {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = convert(arr);
        print(head);
        head = Delete(head, 4);
        print(head);
    }

    public static Node Delete(Node head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        int cnt = 1;
        Node curr = head;
        while (curr != null) {
            if (cnt == k) {
                break;
            }
            curr = curr.next;
            cnt++;
        }
        Node back = curr.prev;
        Node front = curr.next;
        if (back == null && front == null) { // i.e single node
            return null;
        } else if (back == null) { // head
            Node temp = head;
            head = temp.next;
            temp.next = null; // basically calling delete head function
            head.prev = null;
            return head;
        } else if (front == null) { // tail
            back.next = null;
            curr.prev = null; // basically calling delete tail function
            return head;
        } else {
            curr.prev = null;
            curr.next = null;
            back.next = front;
            front.prev = back;
            return head;
        }

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
