// https://www.geeksforgeeks.org/dsa/sort-a-stack-using-recursion/
import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(2);
        s.push(32);
        s.push(3);
        s.push(41);

        sort(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.isEmpty() || s.size() == 1) {
            return s ;
        }
        int top = s.pop() ;
        sort(s) ;
        insert(top , s) ;
        return s ;
    }

    public static void insert(int element , Stack<Integer> s){
        if(s.isEmpty() || s.peek() <= element){
            s.push(element) ;
            return ;
        }
        int top = s.pop() ;
        insert(element , s) ;
        s.push(top) ;
    }
}
