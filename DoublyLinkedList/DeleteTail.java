class Node{
    int data ;
    Node prev ;
    Node next ;
    Node(int data){
        this.data = data ;
        this.next = null ;
        this.prev = null ;
    }
    Node(int data , Node prev , Node next){
        this.data = data ;
        this.prev = prev ;
        this.next = next ;
    }
}
public class DeleteTail{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5} ;
        Node head = convert(arr) ;
        print(head) ;
        head = Delete(head) ;
        print(head) ;
    }

    public static Node Delete(Node head){
        if(head == null || head.next == null) return null ;
        Node curr = head ;
        while(curr.next != null){
            curr = curr.next ;
        }
        // now curr is at last node 
        Node back = curr.prev ; // back is second last node
        back.next = null ;
        curr.prev = null ;
        return head ;
    }
    public static Node convert(int[] arr){
        Node head = new Node(arr[0]) ;
        Node curr = head ;
        for(int i = 1 ; i < arr.length ; i++){
            Node newNode = new Node(arr[i]) ;
            curr.next = newNode ;
            newNode.prev = curr ;
            curr = newNode ;
        }
        return head ;
    }
    public static void print(Node head){
        Node curr = head ;
        System.out.println();
        while(curr!=null){
            System.out.print(curr.data+" <--> ");
            curr = curr.next ;
        }
        System.out.print("null");
        System.out.println();
        System.out.println();
    }
}
