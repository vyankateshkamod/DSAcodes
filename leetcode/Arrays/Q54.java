import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}} ;
        List<Integer> list = new ArrayList<>(spiralOrder(matrix)) ;
        
        for(int i = 0 ;i < list.size() ;i++){
            
            System.out.print(list.get(i) + " ");
            
        }
    }

     //Optimal
    //tc : n*m
    //sc : n*m
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }
        return list;
    }
}
