
import java.util.Stack;

public class Q84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }

    // optimal
    // tc : 2n
    // sc : n
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length ;
        Stack<Integer> stk = new Stack<>() ;
        int maxArea = 0 ;
        for(int i = 0 ; i < n ; i++){
            
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]){
                int height = heights[stk.pop()] ;
                int pse = stk.isEmpty() ? -1 : stk.peek() ;
                int nse = i ;
                int width = nse - pse -1 ;
                int area = height * width ;
                maxArea = Math.max(maxArea , area) ;
            }
            stk.push(i) ;
        }

        while(!stk.isEmpty()){
            int height = heights[stk.pop()] ;
            int pse = stk.isEmpty() ? -1 : stk.peek() ;
            int nse = n ;
            int width = nse - pse -1 ;
            int area = height * width ;
            maxArea = Math.max(maxArea , area) ;
        }

        return maxArea ;
    }

    // better
    // tc : 5n
    // sc : 4n
    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length ;
        int[] pse = findpse(heights) ;
        int[] nse = findnse(heights) ;
        int maxArea = 0 ;
        for(int i = 0 ; i < n ; i++){
            int width = nse[i] - pse[i] -1 ;
            int area = heights[i] * width ;
            maxArea = Math.max(maxArea , area) ;
        }
        return maxArea ;
    }

    public static int[] findpse(int[] arr){
        int n = arr.length ;
        int [] pse = new int[n] ;
        Stack<Integer> stk = new Stack<>() ;
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                stk.pop() ;
            }

            pse[i] = stk.isEmpty() ? -1 : stk.peek() ;

            stk.push(i) ;
        }
        return pse ;
    }

    public static int[] findnse(int[] arr){
        int n = arr.length ;
        int [] nse = new int[n] ;
        Stack<Integer> stk = new Stack<>() ;
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop() ;
            }

            nse[i] = stk.isEmpty() ? n : stk.peek() ;

            stk.push(i) ;
        }
        return nse ;
    }
}