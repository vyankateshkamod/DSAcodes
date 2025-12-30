
import java.util.Stack;

public class Q85 {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        } ;
        System.out.println(maximalRectangle(matrix));
    }

    // pre requisite : histogram problem
    // tc : m*n + n*2m
    // sc : n*m + n
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length ;
        int m = matrix[0].length ;
        int[][] prefSum = new int[n][m] ;

        for(int j = 0 ; j < m ; j++){
            int sum = 0 ;
            for(int i = 0 ; i < n ; i++){
                if(matrix[i][j] == '0'){
                    sum = 0 ;
                } else{
                    sum += 1 ;
                }
                prefSum[i][j] = sum ;
            }
        }

        int maxArea = 0 ;

        for(int i = 0 ; i < n ; i++){
            maxArea = Math.max(maxArea , largestHist(prefSum[i])) ;
        }

        return maxArea ;
    }

    public static int largestHist(int[] heights){
        int n = heights.length ;
        int maxArea = 0 ;
        Stack<Integer> stk = new Stack<>() ;
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]){
                int height = heights[stk.pop()] ;
                int pse = stk.isEmpty() ? -1 : stk.peek() ;
                int nse = i ;
                int width = nse - pse - 1 ;
                int area = height * width ;
                maxArea = Math.max(maxArea , area) ;
            }
            stk.push(i) ;
        }

        while(!stk.isEmpty()){
            int height = heights[stk.pop()] ;
            int pse = stk.isEmpty() ? -1 : stk.peek() ;
            int nse = n ;
            int width = nse - pse - 1 ;
            int area = height * width ;
            maxArea = Math.max(maxArea , area) ;
        }

        return maxArea ;
    }
}