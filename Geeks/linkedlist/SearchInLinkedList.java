class Node{
    int data ;
    Node next ;

    Node(int data){
        this.data = data ;
    }
    Node(int data , Node next){
        this.data = data ;
        this.next = next ;
    }
}
public class SearchInLinkedList {
    
    public static void main(String[] args) {
        Node head = new Node(1,new Node(2,new Node(3,new Node(4)))) ;
        //  1 -> 2 -> 3 -> 4
        System.out.println(searchKey(4, head,5)) ;
    }

    public static boolean searchKey(int n, Node head, int key) {

        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }
}
