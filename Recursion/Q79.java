public class Q79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        String word = "ABCCED" ;
        System.out.println(exist(board, word));
    }

    // tc : m * n * 4^L (L : length of word)
    // sc : L(recursive)
    public static  boolean exist(char[][] board, String word) {
        int m = board.length ;
        int n = board[0].length ;
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}} ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == word.charAt(0) && find(i , j , board , word , 0 , m , n , directions)){
                    return true ;
                }
            }
        }

        return false ;
    }

    public static  boolean find(int i , int j ,char[][] board , String word , int idx , int m , int n , int[][] directions){
        if(idx == word.length()) return true ;
        if(i < 0 || j < 0 || i >= m || j >= n) return false ;
        if(board[i][j] == '$') return false ;
        if(board[i][j] != word.charAt(idx)) return false ;

        char temp = board[i][j] ;
        board[i][j] = '$' ; //mark as visited

        for(int[] dir : directions){
            int new_i = i + dir[0] ;
            int new_j = j + dir[1] ;
            if(find(new_i , new_j , board , word , idx+1 , m , n , directions)){
                return true ;
            }
        }

        board[i][j] = temp ;

        return false ;
    }
}