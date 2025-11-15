import java.util.* ;

public class Q735 {
    public static void main(String[] args) {
        int [] arr = asteroidCollision(new int[] {3,5,-6,2,-1,4}) ;
        for(int i : arr){
            System.out.print(i + "  ");
        }
    }

    // tc : 2n
    // sc : n
    public static  int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                stk.push(arr[i]);
            } else {

                while (!stk.isEmpty() && stk.peek() > 0 && Math.abs(arr[i]) > stk.peek()) {
                    stk.pop();
                }

                if (!stk.isEmpty() && stk.peek() == -arr[i]) {
                    stk.pop();
                }

                else if (stk.isEmpty() || stk.peek() < 0) {
                    stk.push(arr[i]);
                }
            }
        }

        int[] arr2 = new int[stk.size()];
        for (int i = arr2.length - 1; i >= 0; i--) {
            arr2[i] = stk.pop();
        }

        return arr2;

    }
}