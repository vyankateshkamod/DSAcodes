import java.util.HashMap;
import java.util.Map;

public class Q1{
    public static void main(String[] args) {
        int[]arr = (twoSum(new int[]{2,7,11,15} , 9));
        for(int i : arr){
            System.out.print(i);
        }
    }

    // TC : O(n)
    // SC : O(n)
    public static  int[] twoSum(int[] nums, int target) {
        int n = -1 ;
        int m = -1 ;
        Map<Integer,Integer> map = new HashMap<>() ;

        for(int i = 0 ;i<nums.length ;i++){
            if(map.containsKey(target-nums[i])){
               n = map.get(target-nums[i]) ;
               m = i ;
               return new int[]{n,m} ;
            }
            else{
                map.put(nums[i],i) ;
            }
        }
        return new int[]{} ;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[]temp = new int[2] ;
        for(int i = 0 ;i<nums.length ;i++){
            for(int j = i+1 ;j<nums.length ;j++){
                if(nums[i] + nums[j] == target){
                    temp[0] = i ;
                    temp[1] = j ;
                }
            }
        }
        return temp ;
    }
}