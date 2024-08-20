// Squares of a Sorted Array
import java.util.Arrays;
public class Q977 {
    public static void main(String[] args) {
        int[]arr = {-4,-1,0,3,10} ;
        System.out.print(Arrays.toString(sortedSquares(arr)));
    }
    public static int[] sortedSquares(int[] nums) {
        int l =  0 ;
        int r = nums.length-1 ;
        int []res = new int[nums.length] ;
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[i] = nums[l] * nums[l] ;
                l++ ;
            }
            else{
                res[i] = nums[r] * nums[r] ;
                r-- ;
            }
        }
        return res ;
    }
}
