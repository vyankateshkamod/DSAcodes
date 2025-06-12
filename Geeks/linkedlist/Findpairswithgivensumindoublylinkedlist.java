import java.util.ArrayList ;
import java.util.Arrays ;
class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Findpairswithgivensumindoublylinkedlist{

    public static void main(String[] args) {
        int[] input = {1,2,4,5,6,8,9};
        Node head = createDoublyLinkedList(input);

        System.out.println("Doubly Linked List:");
        print(head);
        System.out.print(findPairsWithGivenSum(7, head));
    }

    // optimal 
    // tc : 2n
    // sc : 1
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
        
        Node left = head ;
        Node right = head ;
        while(right.next != null){
            right = right.next ;
        }
        
        while(left.data < right.data){
            if(left.data + right.data == target){
                list.add(new ArrayList<>(Arrays.asList(left.data,right.data))) ;
                left = left.next ;
                right = right.prev ;
            }
            
            else if(left.data + right.data > target){
                right = right.prev ;
            }
            
            else if(left.data + right.data < target){
                left = left.next ;
            }
        }
        
        return list ;
    }

    // brute 
    // tc : n2
    // sc : 1
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum2(int target,Node head) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
        
        for(Node temp = head ; temp != null && temp.data <= target ; temp = temp.next){
            
            for(Node curr = temp.next ; curr != null && temp.data + curr.data <= target ; curr = curr.next){
                
                if(curr.data == target - temp.data){
                    list.add(new ArrayList<>(Arrays.asList(temp.data , curr.data))) ;
                }
            }
        }
        
        return list ;
    }

        // Method to create doubly linked list from array
    public static Node createDoublyLinkedList(int[] arr) {
        if (arr.length == 0) return null;

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
