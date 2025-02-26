
import java.util.Arrays;

public class Q34 {
    public static void main(String[] args) {
        int[]arr = {5,7,7,8,8,10} ;
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    // tc : 2 log n
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length ;
        int start = findstart(nums,n,target) ;  // finding floor
        if(start == -1) return new int[]{-1,-1} ;
        int end = findend(nums,n,target) ;      // finding ceil
        return new int[]{start,end} ;
    }

    public static int findstart(int[]nums,int n ,int target){
        int low  = 0 ;
        int high = n - 1 ;
        int ans = -1 ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(nums[mid] == target){
                ans = mid ;
                high = mid - 1 ;
            }
            else if(nums[mid] > target){
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return ans ;
    }

    public static int findend(int[]nums,int n ,int target){
        int low  = 0 ;
        int high = n - 1 ;
        int ans = -1 ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(nums[mid] == target){
                ans = mid ;
                low  = mid + 1 ;
            }
            else if(nums[mid] < target){
                low  = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        return ans ;
    }
}
