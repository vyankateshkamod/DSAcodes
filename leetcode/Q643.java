//643. Maximum Average Subarray I

public class Q643 {
    public static void main(String[] args) {
        int []arr={1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(arr,4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double ans = -1;
        double window = 0;
        int left=0;
        double avg = 0;
        for (int i = 0; i < k; i++) {
            window += nums[i];
        }
        ans = window / k;
        for (int right = k; right < nums.length; right++) {
            window += nums[right] - nums[left];
            left++;
            avg = window / k;
            ans = Math.max(ans, avg);
        }
        return ans;
    }
}
