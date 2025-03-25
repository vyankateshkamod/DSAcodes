public class Q540 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
    public static  int singleNonDuplicate(int[] nums) {
        int n = nums.length ;
        if(n == 1) return nums[0] ;
        if(nums[0] != nums[1]) return nums[0] ;
        if(nums[n-1] != nums[n-2]) return nums[n-1] ;

        int low = 1 ;
        int high = n-2 ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid] ;
            }
            // we are on left
            if( (nums[mid] % 2 == 1 && nums[mid] == nums[mid-1]) || (nums[mid] % 2 == 0 && nums[mid] == nums[mid+1])){
                low = mid + 1 ;
            }
            // we are on right
            else{
                high = mid - 1 ;
            }
        }
        return -1 ;
    }

    // my sol
    public int singleNonDuplicate2(int[] nums) {
        int n = nums.length ;
        if(n == 1) return nums[0] ;
        if(nums[0] != nums[1]) return nums[0] ;
        if(nums[n-1] != nums[n-2]) return nums[n-1] ;

        int low = 1 ;
        int high = n-2 ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid] ;
            }
            else{
                if(nums[mid] != nums[mid-1]){
                    if(mid % 2 != 0){
                        high = mid - 1 ;
                    }
                    else{
                        low = mid + 1 ;
                    }
                }
                else{
                    if(mid % 2 == 0){
                        high = mid -1 ;
                    }
                    else{
                        low = mid + 1 ;
                    }
                }
            }
        }
        return -1 ;
    }
}
