import java.util.* ;
public class MColoringProblem {
    public static void main(String[] args) {
        int v = 4 ;
        int[][] edges = {
            {0,1},
            {1,3},
            {2,3},
            {3,0},
            {0,2},
        } ;
        int m = 3 ;
        System.out.println(graphColoring(v, edges, m));
    }

    // tc : v^m
    // sc : v + v
    static  boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> graph = new ArrayList<>(v) ;
        
        for(int i = 0 ; i < v ; i++){
            graph.add(i , new ArrayList<>()) ;
        }
        
        for(int[] edge : edges){
            int x = edge[0] ;
            int y = edge[1] ;
            graph.get(x).add(y) ;
            graph.get(y).add(x) ;
        }
        
        int[] color = new int[v] ;
        
        return solve(0 ,graph , color , m) ;
    }
    
    static  boolean solve(int node , List<List<Integer>> graph ,int[] color , int m){
        if(node == graph.size()){
            return true ;
        }
        
        for(int col = 1 ; col <= m ; col++){
            if(isSafe(node , col , graph , color)){
                color[node] = col ;
                if(solve(node + 1 , graph , color , m)){
                    return true ;
                } ;
                color[node] = 0 ;
            }
        }
        
        return false ;
    }
    
    static  boolean isSafe(int node , int col , List<List<Integer>> graph , int[] color){
        for(int neighbor : graph.get(node)){
            if(color[neighbor] == col){
                return false ;
            }
        }
        return true ;
    }
}