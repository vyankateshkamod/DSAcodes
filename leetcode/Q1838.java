import java.util.Arrays;

public class Q1838{
    public static void main(String[] args) {
        System.out.print(maxFrequency(new int[]{1,4,8,13}, 5)) ;
    }

     public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums) ;
        int l = 0 ;
        long currsum = 0 ;
        int result = 0 ;
        for(int r =0 ; r < nums.length ; r++){
            currsum = currsum + nums[r] ;
            long windowsum = (long)nums[r] * (r-l+1) ;
            long operation = windowsum - currsum ;
            if(operation > k){
                currsum = currsum - nums[l] ;
                l++ ;
                operation = windowsum - currsum ;
            }
            result = Math.max(result,r-l+1) ;
        }
        return result ;
    }
}