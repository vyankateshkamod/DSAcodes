public class Q33 {
    public static void main(String[] args) {
        int []arr = {4,5,6,7,0,1,2} ;
        System.out.println(search(arr, 0));
    }

    // tc : logn
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0 ;
        int high = n - 1 ;
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target) return mid ;
            //left sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1 ;
                }
                else{
                    low = mid + 1;
                }
            }
            //right sorted
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1 ;
                }
                else{
                    high = mid - 1 ;
                }
            }
        }

        return -1 ;
    }


    // tc : 2logn
    // my approach
    public static  int search2(int[] nums, int target) {
        int n = nums.length;
        int smallest_idx = findSmallestElement(nums);
        if (nums[smallest_idx] == target) {
            return smallest_idx;
        }
        // serach to right half
        if (nums[n - 1] >= target) {
            return bs(nums, smallest_idx, n - 1, target);
        }
        // search to left half
        else {
            return bs(nums, 0, smallest_idx - 1, target);
        }
    }

    public static int findSmallestElement(int[]nums){
        int n = nums.length ;
        int low = 0 ;
        int high = n - 1 ;
        
        while(low < high){
            int mid = low + (high  - low) / 2 ;
            if(nums[mid] > nums[high]){
                low = mid + 1 ;
            }
            else{
                high = mid ;
            }
        }
        return low ; 
    }

    public static int bs(int[] nums, int low, int high, int target) {
        int n = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
