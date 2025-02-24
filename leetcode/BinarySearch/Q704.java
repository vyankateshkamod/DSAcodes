public class Q704{
    public static void main(String[] args) {
        System.out.println(search(new int[]{0,1,2,3,4,5,6,7,8,9}, 7));
    }
     // recursive
    // tc : logn  // base = 2
    // assign mid = low + (high - low) / 2  to avoid overflow condition
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1 ;
        return bs( nums,low,high,target) ;
    }

    public static int bs(int[]nums,int low,int high,int target){
        if(low <= high){
            int mid = (low + high) / 2 ;
            if(target == nums[mid]) return mid ;
            else if(target < nums[mid]) {
                return bs(nums,low,mid-1,target) ;
            }
            else{
                return bs(nums,mid+1,high,target) ;
            }
        } 
        return -1 ;
    }

    // iterative
    // tc : logn
    public static int search2(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}