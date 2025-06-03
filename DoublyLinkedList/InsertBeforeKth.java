
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

public class InsertBeforeKth {

    public static void main(String[] args) {
        int[] arr = {22, 33, 44, 55, 66};
        Node head = convert(arr);
        print(head);
        head = Insert(head, 4, 25);
        print(head);
    }

    public static Node Insert(Node head, int k, int x) {
        int cnt = 1 ;
        Node front = head ;
        while(cnt != k){
            front = front.next ;
            cnt++ ;
        }
        Node back = front.prev ;
        Node newNode = new Node(back , x , front) ;
        back.next = newNode ;
        front.prev = newNode ;
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
