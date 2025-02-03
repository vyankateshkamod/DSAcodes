

public class Q53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        int[]arr = maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}) ;
        System.out.print("Subarray : [ ");
        for(int i : arr){
            System.out.print(i+",");
        }
        System.out.print("]");

    }

    // Kadane’s Algorithm
    // TC : O(n)
    // SC : O(1)
    public static int maxSubArray(int[] nums) {
        int max = nums[0] ;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0 ;
            }
              
        }

        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int sum = Integer.MIN_VALUE ;
    
        for(int i = 0; i < nums.length; i++) {
            int sum2 = 0 ;
            for(int j = i ; j < nums.length ;j++){
                sum2 = sum2 + nums[j] ;
                sum = Math.max(sum,sum2) ;
            }
        }
    
        return sum ; 
    }

    //follow up question 
    //return subarray of maximum sum
    public static int[] maxSubArray3(int[] nums) {
        int max = nums[0] ;
        int sum = 0;
        int start = -1 ;
        int end = -1 ;
        int anstart = -1 ;

        for (int i = 0; i < nums.length; i++) {
            if(sum==0){
                start = i ;
            }
            sum = sum + nums[i];                         //0 1  2 3  4 5 6  7 8
                                                        //-2,1,-3,4,-1,2,1,-5,4
            if(sum > max){
                max = sum ;
                anstart = start ;
                end = i ;
            }

            if (sum < 0) {
                sum = 0 ;
            }
            
        }
        int[] temp = new int[end-anstart+1] ;
        int j = 0 ;
        for(int i = anstart ;i<=end ;i++){
            temp[j] = nums[i] ;
            j++ ;
        }
        return temp ;
    }
}
