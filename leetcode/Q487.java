//Max Consecutive Ones II

public class Q487 {
    public static void main(String[] args) {
        int[]array = {1,0,1,1,0};
        System.out.println("Maximum ones are : "+findMaxConsecutiveOnes(array));
    }
    public static int findMaxConsecutiveOnes(int[]nums){
        int left = 0 ;
        int window = 0 ;
        int ans = 0 ;
        //    [  1, 0, 1, 1, 0  ]
        for(int right=0;right < nums.length ; right++){
            window += nums[right];
            // 0 zero || 1 zero
            while(!(window==right-left+1 || window==right-left)){
                window -= nums[left] ;
                left++;
            }
            ans = Math.max(ans,right-left+1) ;
        }
        return ans ;
    }

}
