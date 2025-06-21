import java.util.ArrayList ;
import java.util.List ;

public class Q78 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>() ;
        arr = subsets(new int[] {1,2,3}) ;
        for(List<Integer> set : arr){
            System.out.print(set + " , ");
        }
    }

    // recursive
    // tc : 2^n
    // sc : 2^n * n
    public static List<List<Integer>> list = new ArrayList<>() ;

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>() ;
        solve(nums , 0 , temp ) ;
        return list ;
    }

    public static void solve(int[] nums , int i , List<Integer> temp){
        if(i >= nums.length){
            list.add(new ArrayList<>(temp)) ;
            return ;
        }
        // Include nums[i]
        temp.add(nums[i]) ;
        solve(nums , i+1 , temp ) ;
        // Exclude nums[i]
        temp.remove(temp.size()-1) ;
        solve(nums , i+1 , temp ) ;
    }
}