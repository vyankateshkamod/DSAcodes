
import java.util.LinkedList;
import java.util.Queue;

public class Q225 {

    public static void main(String[] args) {
        MyStack stk = new MyStack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.display();
        stk.pop();
        stk.display();
        System.out.println(stk.top());
        System.out.println(stk.empty());
    }
}

class MyStack {

    Queue<Integer> Q;

    public MyStack() {
        Q = new LinkedList<>();
    }

    public void push(int x) {
        Q.offer(x);
        for (int i = 0; i < Q.size() - 1; i++) {
            Q.offer(Q.peek());
            Q.poll();
        }
    }

    public int pop() {
        return Q.poll();
    }

    public int top() {
        return Q.peek();
    }

    public boolean empty() {
        return Q.isEmpty();
    }

    public void display() {
        for (Integer i : Q) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
