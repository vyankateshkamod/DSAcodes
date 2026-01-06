
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class TheCelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 1}
        };

        System.out.println(celebrity(mat));
    }

    // optimal
    // tc : n
    // sc : 1
    public static int celebrity(int mat[][]) {
        
        int n = mat.length ;
        
        int top = 0 ; 
        int bottom = n-1 ;
        while(top < bottom){
            
            if(mat[top][bottom] == 1){
                top++;
            } else{
                bottom--;
            }

        }
        
        
        for(int i = 0 ; i < n ; i++){
            if(top != i){
                if(mat[top][i] == 1 || mat[i][top] == 0){ 
                    return -1 ;
                }
            }
        }
        
        return top ;
        
    }

    // better
    // tc : n
    // sc : n
    public static int celebrity2(int mat[][]) {
        
        int n = mat.length ;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            stk.push(i);
        }
        
        while(stk.size() > 1){
            int a = stk.pop() ;
            int b = stk.pop() ;
            
            if(mat[a][b] == 1) {
                stk.push(b);
            }else{
                stk.push(a);
            }
        }
        
        
        int peek = stk.pop() ;
        for(int i = 0 ; i < n ; i++){
            if(peek != i){
                if(mat[peek][i] == 1 || mat[i][peek] == 0){ 
                    return -1 ;
                }
            }
        }
        
        return peek ;
        
    }

    // tc : n2
    // sc : n
    public static  int celebrity3(int mat[][]) {
        
        int n = mat.length ;
        HashMap<Integer,Integer> knowsBy = new HashMap<>();
        HashSet<Integer> knowsSomeone = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            knowsBy.put(i,0);
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 1 && i != j){
                    knowsBy.put(j, knowsBy.get(j)+1);
                    knowsSomeone.add(i);
                }
            }
        }
        
        for(int key : knowsBy.keySet()){
            if(knowsBy.get(key) == n-1 && !knowsSomeone.contains(key)){
                return key ;
            }
        }
        
        return -1 ;
    }
}