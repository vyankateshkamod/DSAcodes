public class Q35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{2,3,4,5,6,8}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length ;
        int low = 0 ;
        int high = n - 1 ;
        int ans = n  ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(nums[mid] >= target){
                ans = mid ;
                high  = mid - 1 ;
            }
            else{
                low   = mid + 1 ;
            }
        }
        return ans ;
    }
}
