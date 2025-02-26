
public class Numberofoccurrence {
    public static void main(String[] args) {
        int[]arr = {5,7,7,8,8,10} ;
        System.out.println(countFreq(arr, 8));
    }

    public static int countFreq(int[] nums, int target) {
        int[] arr = searchRange(nums,target) ;
        if(arr[0] == -1) return 0 ;
        return arr[1]- arr[0] + 1 ;
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length ;
        int start = findstart(nums,n,target) ;  // finding floor
        if(start == -1) return new int[]{-1,-1} ;
        int end = findend(nums,n,target) ;      // finding ceil
        return new int[]{start,end} ;
    }
    
    public static  int findstart(int[]nums,int n ,int target){
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

    public static  int findend(int[]nums,int n ,int target){
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
