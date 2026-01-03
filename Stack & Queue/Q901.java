
import java.util.Arrays;
import java.util.Stack;

public class Q901 {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        int[] arr = {100,80,60,70,60,75,85} ;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = obj.next(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
}

class StockSpanner {
    // tc : n
    // sc : n
    Stack<int[]> stk = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int span = 1;
        while (!stk.isEmpty() && stk.peek()[0] <= price) {
            span += stk.peek()[1];
            stk.pop();
        }
        stk.push(new int[]{price,span});
        return span;
    }
}