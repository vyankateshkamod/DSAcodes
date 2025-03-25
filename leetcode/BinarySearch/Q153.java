public class Q153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
     // tc : log n
     public static int findMin(int[] nums) {
        int n = nums.length ;
        int low = 0 ;
        int high = n - 1 ;
        int res = Integer.MAX_VALUE ;
        while(low <= high){ 
            int mid = low + (high - low)/2 ;

            if(nums[low] <= nums[high]){
                res = Math.min(res,nums[low]) ;
                break ;
            }

            if(nums[low] <= nums[mid]){
                res = Math.min(res , nums[low]) ;
                low = mid + 1 ;
            }
            else{
                res = Math.min(res,nums[mid]) ;
                high = mid - 1 ;
            }
        }
        return res ;
    }
}
