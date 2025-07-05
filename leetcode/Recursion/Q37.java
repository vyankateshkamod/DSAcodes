
public class Q37 {

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);

        for(char[] row : board){
            for(char ch : row){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    // tc : 9^81
    // sc : n(recursion)
    public static void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }

    public static boolean solve(int row, int col, char[][] board) {
        if (row == board.length) {
            return true;
        }
        if (col == board.length) {
            return solve(row + 1, 0, board);
        }
        if (board[row][col] != '.') {
            return solve(row, col + 1, board);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(row, col, digit, board)) {
                board[row][col] = (char) ('0' + digit);
                if (solve(row, col + 1, board)) {
                    return true;
                };
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isSafe(int row, int col, int digit, char[][] board) {
        // horizontal
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == '0' + digit) {
                return false;
            }
        }

        // vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '0' + digit) {
                return false;
            }
        }

        // gird(3 cross 3)
        int stRow = (row / 3) * 3;
        int stCol = (col / 3) * 3;

        for (int i = stRow; i <= stRow + 2; i++) {
            for (int j = stCol; j <= stCol + 2; j++) {
                if (board[i][j] == '0' + digit) {
                    return false;
                }
            }
        }

        return true;
    }
}
