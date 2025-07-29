//FIFO
public class QueueUsingLinkedList {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.display();
        q.pop();
        q.display();
    }
}

class MyQueue {

    class QueueNode {

        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;

    void push(int a) {
        QueueNode temp = new QueueNode(a);
        if (front == null) {
            front = temp;
            rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    int pop() {
        if (front == null) {
            System.out.println("cant pop");
            return -1;
        }
        int x = front.data;
        front = front.next;
        return x;
    }

    void display() {
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
