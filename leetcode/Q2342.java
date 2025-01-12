import java.util.HashMap;
import java.util.Map;

public class Q2342{
    public static void main(String[] args) {
        Q2342 obj = new Q2342() ;
        System.out.println(obj.maximumSum(new int[]{18,43,36,13,7})) ;
    }
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>() ;
        int ans = -1 ;
        for(int i = 0  ; i < nums.length ; i++){
            int key = sum(nums[i]) ;
            if(map.containsKey(key)){
                ans = Math.max(ans,nums[i]+map.get(key)) ;
                if(nums[i]>map.get(key)){
                    map.put(key,nums[i]) ;
                }
            }
            else{
                map.put(key,nums[i]) ;
            }
        }
        return ans ;
    }

    private int sum(int n){
        int sum = 0 ;
        while(n > 0){
            sum = sum + n % 10 ;
            n = n/10 ;
        }
        return sum ;
    }
}