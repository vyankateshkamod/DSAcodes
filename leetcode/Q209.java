//209. Minimum Size Subarray Sum
public class Q209 {
    public static void main(String[] arg){
        int[]arr = {2,3,1,2,4,3} ;
        System.out.println(minSubArrayLen(7,arr));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int window = 0;
        int res = nums.length + 1;
        for(;r<nums.length;r++){
            window+=nums[r];
            while(window>=target){
                res = Math.min(res,r-l+1);
                window -= nums[l];
                l++;
            }
        }
        return res==nums.length + 1 ? 0 : res ;
    }
}
