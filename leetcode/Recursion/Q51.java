import java.util.* ;
public class Q51 {
    public static void main(String[] args) {
        for(List<String> board : solveNQueens(4)){
            int i = 1 ;
            System.out.println("Solution : "+ i);
            for(String str : board){
                System.out.println(str);
            }
            i++ ;
        }
    }

    // tc : n!
    // SC = O(k * n²), where k = number of valid solutions
    public static  List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>() ;
        char[][] board = new char[n][n] ;
        for(char[] row : board){
            Arrays.fill(row , '.') ;
        }
        solve(0 , board , n , ans) ;
        return ans ;
    }

    public static  void solve(int row , char[][] board, int n , List<List<String>> ans){
        if(row == n){
            ans.add(construct(board)) ;  
            return ;
        }

        for(int col = 0 ; col < n ; col++){
            if(isSafe(row , col , board , n)){
                board[row][col] = 'Q' ;
                solve(row + 1 , board , n , ans) ;
                board[row][col] = '.' ;
            }
        }
    }

    public static  boolean isSafe(int row , int col , char[][] board ,int n){
        // check vertical(same col , diff row)
        for(int i = 0 ; i < n ; i++){
            if(board[i][col] == 'Q') return false ;
        }
        // check horizontally (same row , diff col)
        for(int i = 0 ; i < n ; i++){
            if(board[row][i] == 'Q') return false ;
        }
        // check left diagonal (change row- , change col-)
        for(int i = row ,  j = col ; i >= 0 && j >= 0 ; i-- , j--){
            if(board[i][j] == 'Q') return false ;
        }
        // check right digonal (change row- , change col+ )
        for(int i = row ,  j = col ; i >=0 && j < n ; i-- , j++){
            if(board[i][j] == 'Q') return false ;
        }

        return true ;
    }

    public static  List<String> construct(char[][] board){
        List<String> result = new ArrayList<>() ;
        for(char[] row : board){
            result.add(new String(row)) ;
        }
        return result ;
    }
}