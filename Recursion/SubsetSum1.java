import java.util.* ;
public class SubsetSum1 {
    public static void main(String[] args) {
        for(Integer num : subsetSums(new int[]{3,1,2})){
            System.out.print(num + " ");
        }
    }

    // tc : 2^n + sorting => 2^n log 2^n , because size of list is is 2^n
    // sc : aux : 2^n , stack : n
    public static  List<Integer> subsetSums(int[] nums) {
        List<Integer> list = new ArrayList<>() ;
        solve(nums , 0 , 0 , list) ;
        Collections.sort(list) ;
        return list ;
    }

    public static void solve(int[] nums , int sum , int i , List<Integer> list){
        if(i == nums.length){
            list.add(sum) ;
            return ;
        }
        solve(nums , sum + nums[i] , i+1 , list) ;
        
        solve(nums , sum , i+1 , list) ;
    }
}