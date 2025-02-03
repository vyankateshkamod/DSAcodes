public class Q75 {
    public static void main(String[] args) {
        int[]arr = {2,0,2,1,1,0} ;
        sortColors(arr);
        for(int num : arr){
            System.out.print(num);
        }
    }

    //Dutch national flag algorithm
    // TC : O(n)
    // SC : O(1)
    public static void sortColors(int[] nums) {
        int low = 0 ;
        int mid = 0 ;
        int high = nums.length - 1 ;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[mid] ;
                nums[mid] = nums[low] ;
                nums[low] = temp ;
                low++ ;
                mid++ ;
            }
            else if(nums[mid]==1){
                mid++ ;
            }
            else if(nums[mid]==2){
                int temp = nums[mid] ;
                nums[mid] = nums[high] ;
                nums[high] = temp ;
                high-- ;
            }
        }
    }

    //TC : O(2n)
    //SC : O(1)
    public void sortColors2(int[] nums) {
        int cnt0 = 0 ;
        int cnt1 = 0 ;
        int cnt2 = 0 ;
        for(int num : nums){
            if(num == 0){
                cnt0++ ;
            }
            else if(num== 1){
                cnt1++ ;
            }
            else if(num== 2){
                cnt2++ ;
            }
        }

        for(int i = 0 ; i<cnt0 ;i++){
           nums[i] = 0 ;
        }

        for(int i = cnt0 ; i< cnt0 + cnt1 ;i++){
           nums[i] = 1 ;
        }

        for(int i = cnt0 + cnt1 ; i< cnt0 + cnt1 + cnt2 ;i++){
           nums[i] = 2 ;
        }
    }
}
