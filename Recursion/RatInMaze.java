import java.util.* ;
public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze = {
            {1,0,0,0} , 
            {1,1,0,1} ,
            {1,1,0,0} ,
            {0,1,1,1} ,
        } ;

        for(String str : ratInMaze(maze)){
            System.out.println(str);
        }
    }

    // tc : 3^n2
    // sc : (n2) recursive depth
    public static  ArrayList<String> ratInMaze(int[][] maze) {
        Set<String> set = new HashSet<>() ;
        StringBuilder path = new StringBuilder() ;
        int n = maze.length ;
        solve(0 , 0 ,set , path , maze ,  n) ;
        ArrayList<String> ans = new ArrayList<>(set) ;
        Collections.sort(ans) ;
        return ans ;
    }
    
    public static  void solve(int row , int col , Set<String> ans , StringBuilder path , int[][] maze  ,int n){
        
        if(row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0 || maze[row][col] == -1){
            return  ;
        }
        
        if(row == n-1 && col == n-1){
            ans.add(path.toString()) ;
            return ;
        }
        
        maze[row][col] = -1;
        
        
        path.append("D");
        solve(row + 1, col, ans, path, maze, n);
        path.deleteCharAt(path.length() - 1);
        
        path.append("U");
        solve(row - 1, col, ans, path, maze, n);
        path.deleteCharAt(path.length() - 1);
        
        path.append("L");
        solve(row, col - 1, ans, path, maze,  n);
        path.deleteCharAt(path.length() - 1);
        
        path.append("R");
        solve(row, col + 1, ans, path, maze,  n);
        path.deleteCharAt(path.length() - 1);
        
        maze[row][col] = 1;

    }

}
