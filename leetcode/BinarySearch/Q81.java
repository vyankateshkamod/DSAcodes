public class Q81{
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,0,3,3,3,3,3}, 0));
    }

    //tc : av : logn , worst : n , best : 1
    public static  boolean search(int[] nums, int target) {
        int n = nums.length ;
        int low = 0 ;
        int high = n - 1 ;
        while(low <= high){
            int mid = low + ( high - low ) / 2 ;
            if(nums[mid] == target){
                return true ;
            }

            if(nums[low] == nums[mid] && nums[high] == nums[mid]){
                low ++ ;
                high -- ;
                continue ;
            }

            // left sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1 ;
                }
                else{
                    low = mid + 1 ;
                }
            }

            // right sorted
            else{
                if(nums[mid]<= target && target <= nums[high] ){
                    low = mid + 1 ;
                }
                else{
                    high = mid - 1 ;
                }
            }

        }
        return false ;
    }
}