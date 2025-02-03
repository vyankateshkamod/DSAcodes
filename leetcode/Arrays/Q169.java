import java.util.HashMap;
import java.util.Map;

public class Q169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,4,4}));
    }

    // Moore voting algorithm
    // TC : O(n)
    // SC : O(1)
    public static int majorityElement(int[] nums) {
        int major = nums.length / 2;
        int cnt = 0 ;
        int e = -1 ;
        for(int i = 0 ; i<nums.length ;i++){
            
            if(cnt == 0){
                cnt = 1 ;
                e = nums[i] ;
            }

            else if(e == nums[i]){
                cnt++ ;
            }

            else{
                cnt-- ;
            }
        }

        int cnt2 = 0 ;
        for(int i : nums){
            if(i == e){
                cnt2++ ;
            }
        }

        if(cnt2 > major){
            return e ;
        }

        return -1 ;

    }

    //Better
    //TC : O(n)
    //SC : O(n)
    public int majorityElement2(int[] nums) {
        int major = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {

            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > major) {
                return i;
            }

        }
        return -1;

    }


    //BRute
    public int majorityElement3(int[] nums) {
        int major = nums.length / 2;
        

        for(int i = 0 ; i<nums.length ;i++){
            int cnt = 0 ;
            int e = nums[i] ;
            for(int j = 0 ; j < nums.length ;j++){
                int f = nums[j] ;
                if(e == f){
                    cnt++ ;
                }
                if(cnt > major){
                    return nums[i] ;
                }
            }
        }

        return nums[0] ;

    }
}
