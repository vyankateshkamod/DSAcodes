public class Q48 {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Before");
        for(int i = 0 ;i < matrix.length ;i++){
            for(int j = 0 ; j< matrix[0].length ;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        rotate2(matrix);
        System.out.println("After");
        for(int i = 0 ;i < matrix.length ;i++){
            for(int j = 0 ; j< matrix[0].length ;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Optimal
    // tc: n2
    // sc: 1
    public static void rotate2(int[][] matrix) {

        int n = matrix.length;

        // transpose the matix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                // swap upper triangle elements with lower triangle
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }

            }
        }

        // reverse the transformed matrix
        for (int i = 0; i < n; i++) {
            int k = 0;
            int j = n - 1;
            while (k < j) {
                // swap
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
                k++;
                j--;
            }
        }

    }

    //Brute
    //tc: n2 
    //sc: n2
    public void rotate(int[][] matrix) {

        int n = matrix.length ;

        int arr[][] = new int[n][n] ;

        // col same row changing 
        for(int j = 0 ; j<n ;j++){
            for(int i = n-1 ;i>=0 ;i--){
                arr[j][n-i-1] = matrix[i][j] ;
            }
        }

        for(int i = 0 ;i < n ;i++){
            for(int j = 0 ; j < n ;j++){
                matrix[i][j] = arr[i][j] ;
            }
        }
    }
}
