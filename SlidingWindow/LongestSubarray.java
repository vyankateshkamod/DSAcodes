
import java.util.Arrays;

public class LongestSubarray {

    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        LongestSubarray obj = new LongestSubarray();

        for (int i = 0; i < 10_000; i++) {
            obj.longestSubarray(arr, 500_000);
            obj.longestSubarray2(arr, 500_000);
        }

        int runs = 100;

        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            obj.longestSubarray(arr, 500_000);
        }
        long end = System.nanoTime();
        System.out.println("Method 1 avg ms: "
                + (end - start) / 1_000_000.0 / runs);

        start = System.nanoTime();
        for (int i = 0; i < runs; i++) {
            obj.longestSubarray2(arr, 500_000);
        }
        end = System.nanoTime();
        System.out.println("Method 2 avg ms: "
                + (end - start) / 1_000_000.0 / runs);

    }

    // longest subarray sum <= k , return length 
    public int longestSubarray(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int n = arr.length;
        int sum = 0;
        while (r < n) {
            sum = sum + arr[r];
            if (sum > k) {
                sum = sum - arr[l];
                l++;
            } else if (sum <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public int longestSubarray2(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int n = arr.length;
        int sum = 0;
        while (r < n) {
            sum = sum + arr[r];
            while (sum > k) {
                sum = sum - arr[l];
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
