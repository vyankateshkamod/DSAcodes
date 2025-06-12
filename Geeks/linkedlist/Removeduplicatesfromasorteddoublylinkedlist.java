
class Node {

    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Removeduplicatesfromasorteddoublylinkedlist {

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 4, 6, 8, 8};
        Node head = createDoublyLinkedList(input);

        System.out.println("Doubly Linked List:");
        print(head);
        print(removeDuplicates(head));
    }

    static Node removeDuplicates(Node head) {
        Node temp = head;
        Node front = temp;
        while (temp != null) {
            front = temp.next;

            if (front != null && front.data == temp.data) {
                while (front != null && front.data == temp.data) {
                    front = front.next;
                }

                temp.next = front;
                if (front != null) {
                    front.prev = temp;
                }
                temp = front;
            } else {
                temp = temp.next;
            }

        }

        return head;
    }

    // Method to create doubly linked list from array
    public static Node createDoublyLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        return head;
    }

    // Print the doubly linked list
    public static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <--> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
