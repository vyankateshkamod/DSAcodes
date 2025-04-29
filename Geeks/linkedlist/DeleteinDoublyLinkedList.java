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

public class DeleteinDoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = convert(arr);
        print(head);
        head = deleteNode(head, 9);
        print(head);
    }

    public static  Node deleteNode(Node head, int x) {
        int cnt = 1;
        Node curr = head;
        while (curr != null) {
            if (cnt == x) {
                break;
            }
            cnt++;
            curr = curr.next;
        }
        if (curr == null)
            return head;
        Node back = curr.prev;
        Node front = curr.next;
        if (back == null && front == null) {
            return null;
        } else if (back == null) {
            head = front;
            front.prev = null;
            curr.next = null;
            curr.prev = null;
        } else if (front == null) {
            back.next = null;
            curr.prev = null;
            curr.next = null;
        } else {
            back.next = front;
            front.prev = back;
            curr.prev = null;
            curr.next = null;
        }
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
