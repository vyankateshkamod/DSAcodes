class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class DoublyLinkedListInsertionAtGivenPosition {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        print(head);
        addNode(head, 1, 46);
        print(head);
    }

    public static Node addNode(Node head, int p, int x) {
        int cnt = 0;
        Node cur = head;
        while (cur != null) {
            if (cnt == p) {
                break;
            }
            cnt++;
            cur = cur.next;
        }

        if (cur == null)
            return head;

        Node newNode = new Node(x);
        newNode.next = cur.next;
        if (cur.next != null) {
            cur.next.prev = newNode;
        }
        newNode.prev = cur;
        cur.next = newNode;
        return head;
    }

    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " --> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
