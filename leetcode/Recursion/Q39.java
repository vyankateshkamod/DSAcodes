import java.util.* ;
public class Q39 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>() ;
        list = combinationSum(new int[]{2,3,6,7}, 7) ;
        for(List<Integer> temp : list){
            System.out.print(temp + ",");
        }
    }

    // tc : 3^n
    // sc : T
    static Set<List<Integer>> set = new HashSet<>() ;

    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> comb = new ArrayList<>() ;
        int i = 0 ;
        solve(i , comb , ans , target , candidates) ;
        return ans ;
    }

    public static  void solve(int i , List<Integer> comb , List<List<Integer>> ans , int target , int[]candidates){
        if(i == candidates.length || target < 0){
            return ;
        }
        if(target == 0){
            if(!set.contains(comb)){
                ans.add(new ArrayList<>(comb)) ;
                set.add(new ArrayList<>(comb)) ;
            }
            return ;
        }
        comb.add(candidates[i]) ;
        // single inclution
        solve(i+1 , comb , ans , target - candidates[i] , candidates) ;
        // multiple inclution
        solve(i , comb , ans , target - candidates[i] , candidates) ;
        // no inclution / dont take
        comb.remove(comb.size()-1) ;
        solve(i+1 , comb , ans , target , candidates) ;
    }
}