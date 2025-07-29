
import java.util.Stack;

public class Q232 {

    public static void main(String[] args) {
        MyQueue Q = new MyQueue();
        Q.push(1);
        Q.push(2);
        Q.push(3);
        Q.push(4);
        Q.display();
        Q.pop();
        Q.display();
    }
}

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // s1 --> s2
        // x ---> s1
        // s2 --> s1
        while (!s1.isEmpty()) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public void display() {
        for (int i = s1.size() - 1; i >= 0; i--) {
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
    }
}
