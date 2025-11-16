
import java.util.*;

public class Q2104 {

    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[]{1, 2, 3}));
    }

    // optimal
    // tc : 10n
    // sc : 10n
    public static long subArrayRanges(int[] nums) {

        long sum = sumLargest(nums) - sumSmallest(nums);

        return sum;
    }

    public static long sumSmallest(int[] arr) {
        int n = arr.length;
        int[] pse = findPse(arr);
        int[] nse = findNse(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            long ctb = (long) left * right * arr[i];
            sum += ctb;
        }
        return sum;
    }

    public static int[] findPse(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                stk.pop();
            }
            pse[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        return pse;
    }

    public static int[] findNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            nse[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }
        return nse;
    }

    public static long sumLargest(int[] arr) {
        int n = arr.length;
        int[] pge = findPge(arr);
        int[] nge = findNge(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            long ctb = (long) left * right * arr[i];
            sum += ctb;
        }
        return sum;
    }

    public static int[] findPge(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
                stk.pop();
            }
            pge[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        return pge;
    }

    public static int[] findNge(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
                stk.pop();
            }
            nge[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }
        return nge;
    }

    // brute
    // tc : n2
    public static long subArrayRanges2(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                int range = max - min;
                sum += range;
            }
        }
        return sum;
    }
}
