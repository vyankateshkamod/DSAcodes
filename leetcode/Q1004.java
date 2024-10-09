//1004. Max Consecutive Ones III

public class Q1004 {
    public static void main(String[] args) {
        int[]array  = {1,1,1,1,0,0,0,1,1,1,1,1,0,0} ;
        System.out.println(longestOnes(array, 2));
    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int window = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            window += nums[right];
            while (window + k < right - left + 1) {
                window -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
