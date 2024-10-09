//Sliding window approach 

import java.util.Arrays ;

public class Q2090sec {
    public static void main(String[] args) {
        int[]array = {7,4,3,9,1,8,5,2,6} ;
        System.out.println(Arrays.toString(getAverages(array, 3)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        long window = 0;
        int idx = k * 2 + 1;
        int avg = k;
        if (idx > n) {
            return res;
        }
        for (int i = 0; i < idx; i++) {
            window += nums[i];
        }
        res[avg] = (int) (window / idx);
        for (int i = idx; i < n; i++) {
            window = window - nums[i - idx] + nums[i];
            res[++k] = (int) (window / idx);
        }
        return res;
    }
}
