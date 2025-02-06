public class Q31 {
    public static void main(String[] args){
        int []arr = {1,2,3}  ;
        nextPermutation(arr);
        for(int i :arr){
            System.out.print(i+" ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length ;
        //find gola index
        int gola_idx = -1 ;
        for(int i = n-1 ;i>0 ;i--){
            if(nums[i-1] < nums[i]){
                gola_idx = i-1 ;
                break ;
            }
        }
        
        // find swap index
        

        if(gola_idx != -1){
            int swap_idx = gola_idx ;
            for(int i = n-1 ; i>gola_idx ;i--){

                if(nums[i] > nums[gola_idx]){
                    swap_idx = i ;
                    break ;
                }
            }
            
            //swap 
            int temp = nums[gola_idx] ;
            nums[gola_idx] = nums[swap_idx] ;
            nums[swap_idx] = temp ;
        }
        //Reverse remaing part
        int left = gola_idx + 1 ;
        int right = n-1 ;
        while(left<right){
            int temp = nums[left] ;
            nums[left] = nums[right] ;
            nums[right] = temp ;
            left++ ;
            right-- ;
        }
        
    }
}
