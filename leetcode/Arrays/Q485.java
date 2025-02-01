//Max Consecutive Ones

public class Q485 {
    public static void main(String[] args) {
        int[]nums = {1,2,2,3,4,1,1,1,1,1,1,56,43,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int newcnt = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == 1) {
                cnt++;
                if (cnt > newcnt) {
                    newcnt = cnt;
                }
            } else {
                cnt = 0;
            }
        }
        return newcnt;
    }
}
