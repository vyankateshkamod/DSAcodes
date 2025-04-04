public class Q1283 {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1,2,5,9}, 6));
    }
    // Optimal
    // tc : log max * n
    public static  int smallestDivisor(int[] nums, int threshold) {
       
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]) ;
        }

        int divisor = Integer.MAX_VALUE ;
        int low = 1 ;
        int high = max ;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if(possible(nums,mid,threshold)){
                divisor = Math.min(divisor,mid) ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return divisor ; // or you can return low as well 
    }
    public static  boolean possible(int[] nums,int i , int threshold){
        int sum = 0 ;
        for(int j = 0 ; j < nums.length ; j++){
            sum += Math.ceil((double)nums[j]/i) ;
        }
        if(sum <= threshold){
            return true ;
        }
        return false ;
    }

    //Brute
    // tc : max * n
    public static  int smallestDivisor2(int[] nums, int threshold) {
       
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]) ;
        }

        int divisor = Integer.MAX_VALUE ;
        for(int i = 1 ; i <= max ;i++){
            if(possible(nums,i,threshold)){
                divisor = Math.min(divisor,i) ;
            }
        }
        return divisor ;
    }
    
}
