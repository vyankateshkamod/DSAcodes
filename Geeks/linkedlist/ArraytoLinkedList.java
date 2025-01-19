
class Node {
     int data;
     Node next;

     Node() { data = 0; }
     Node(int d) { data = d; }  //constructor to create a new node
 }
public class ArraytoLinkedList {
    public static void main(String[] args){
        int[]arr = {1,2,3,4,5} ;
        Node head = constructLL(arr) ;
        printlist(head);
    }

    public static Node constructLL(int arr[]) {
        if(arr.length==0){
            return null ;
        }
        Node head = new Node(arr[0]) ;
        Node curr = head ;
        for(int i = 1 ; i < arr.length ;i++){
            curr.next = new Node(arr[i]) ;
            curr = curr.next ;
        }
        return head ;
    }

    public static void printlist(Node head){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}