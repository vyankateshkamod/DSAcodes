public class Q136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }

    // tc : n
    public static int singleNumber(int[] nums) {
        int n = nums.length ;
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            ans = (ans ^ nums[i]) ;
        }
        return ans ;
    }
}