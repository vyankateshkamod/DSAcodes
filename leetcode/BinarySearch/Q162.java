public class Q162 {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length ;
        if(n==1) return 0 ;
        if(nums[0] > nums[1]) return 0 ;
        if(nums[n-1] > nums[n-2]) return n-1 ;
        int low = 1;
        int high = n-2 ;
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid ;
            }
            else if(nums[mid] < nums[mid + 1]){
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        return -1 ;
    }


    // my solution
    public static int findPeakElement2(int[] nums) {
        int n = nums.length ;
        if(n==1) return 0 ;
        if(nums[0] > nums[1]) return 0 ;
        if(nums[n-1] > nums[n-2]) return n-1 ;
        int low = 1;
        int high = n-2 ;
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid ;
            }
            else{
                if(nums[mid] < nums[mid-1]){
                    high = mid - 1 ;
                }
                else if(nums[mid] <= nums[mid+1]){
                    low = mid + 1 ;
                }
            }
        }
        return -1 ;
    }
}
