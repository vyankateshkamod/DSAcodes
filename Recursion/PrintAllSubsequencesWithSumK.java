import java.util.* ;
public class PrintAllSubsequencesWithSumK {
    static List<List<Integer>> list = new ArrayList<>() ;
    public static void main(String[] args) {
        countSubsequenceWithTargetSum(new int[]{4,9,2,5,1}, 10) ;
        for(List<Integer> arr : list){
            System.out.println(arr + ",");
        }
    }

    public static  List<List<Integer>> countSubsequenceWithTargetSum(int[] nums, int k) {
       int sum = 0 ;
       int i = 0 ;
       List<Integer> temp = new ArrayList<>() ;
       solve(i , temp , sum , nums ,k) ;
       return list ;
    }

    public static  void solve(int i , List<Integer> temp , int sum ,int[]nums, int k){
        if(i == nums.length){
            if(sum == k){
                list.add(new ArrayList(temp)) ;
            }
            return ;
        }
        temp.add(nums[i]) ;
        sum = sum + nums[i] ;
        solve(i+1 , temp , sum , nums , k) ;

        temp.remove(temp.size()-1) ;
        sum = sum - nums[i] ;
        solve(i+1 , temp , sum , nums , k) ;
    }
}