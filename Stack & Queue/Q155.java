import java.util.*;
public class Q155 {
    public static void main(String[] args) {
        MinStack stk = new MinStack();
        stk.push(1);
        stk.push(4);
        stk.push(2);
        stk.push(6);
        System.out.println(stk.getMin());
    }
}

class MinStack {
    // tc : 1
    // sc : 2N
    Stack<ArrayList<Integer>> s1;
    int min = Integer.MAX_VALUE ;

    public MinStack() {
        s1 = new Stack<>();
    }
    
    public void push(int val) {
        if(val < min){
            min = val;
        }
        s1.push(new ArrayList<>(Arrays.asList(val,min)));
    }
    
    public void pop() {
        s1.pop();
        if(s1.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = s1.peek().get(1);
        }
    }
    
    public int top() {
        return s1.peek().get(0);
    }
    
    public int getMin() {
        return s1.peek().get(1);
    }
}