public class QueueUsingArray {
    public static void main(String[] args) {
        MyQueue q = new MyQueue() ;
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
        q.display();
        q.pop() ;
        q.pop() ;
        q.pop() ;
        q.pop() ;
        q.pop() ;
        q.display();
        q.pop() ;
        q.pop() ;
        q.pop() ;
        q.pop() ;
        q.pop() ;
        q.display();
    }
}

class MyQueue {

    int front, rear;
    int size = 10 ;
    int arr[] = new int[size];
    int currSize = 0 ;

    MyQueue() {
        front = -1;
        rear = -1;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        if(currSize == size){
            System.out.println("cannot push element");
            return ;
        }
        if(currSize == 0){
            front = 0;
            rear = 0 ;
        }
        arr[rear] = x ;
        rear = (rear+1) % size ;
        currSize++ ;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(currSize == 0){
            return -1 ;
        }
        int x = arr[front] ;
        if(currSize == 1){
            front = -1 ;
            rear = -1 ;
        }
        else{
            front = (front+1) % size ;
        }
        currSize-- ;
        return x ;
    }

    void display(){
        if(currSize == 0){
            System.out.println("empty stack");
            return ;
        }
        int count = currSize ;
        for(int i = front ; count > 0 ; i = (i+1)%size , count--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}