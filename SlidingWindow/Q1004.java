
public class Q1004 {

    public static void main(String[] args) {
        int[]nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

    // optimal
    // tc : n
    // sc : 1
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeros = 0;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            if (zeros <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }

        return maxLen;
    }

    //better
    // tc : 2n
    // sc : 1
    public static int longestOnes2(int[] nums, int k) {
        int n = nums.length;
        int zeros = 0;
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
                while (zeros > k) {
                    if (nums[l] == 0) {
                        zeros--;
                    }
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    // brute
    // tc : n2
    // sc : 1
    public static int longestOnes3(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                if (zeros <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

}
