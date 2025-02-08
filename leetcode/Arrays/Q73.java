public class Q73 {
    public static void main(String[] args) {
        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int i = 0 ;i < matrix.length ;i++){
            for(int j = 0 ; j< matrix[0].length ;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Optimal
    // tc : 2*n*m
    // sc : 1
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // int[]col = matrix[0][...]
        // int[]row = matrix[...][0]

        int col0 = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    // check for col and row
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }

                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 1; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Better
    // tc : 2*n*m
    // sc : n+m
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Brute
    //tc : (n*m)*(n+m)+(n*m) approx : n3
    //sc : 1
    public void setZeroes3(int[][] matrix) {
        int rowlength = matrix.length;
        int colength = matrix[0].length;

        for (int i = 0; i < rowlength; i++) {
            for (int j = 0; j < colength; j++) {
                if (matrix[i][j] == 0) {
                    makerow(i, colength, matrix);
                    makecol(j, rowlength, matrix);
                }
            }
        }

        for (int i = 0; i < rowlength; i++) {
            for (int j = 0; j < colength; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void makerow(int row, int colength, int[][] matrix) {
        for (int i = 0; i < colength; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = -1;
            }
        }
    }

    public void makecol(int col, int rowlength, int[][] matrix) {
        for (int i = 0; i < rowlength; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }
}
