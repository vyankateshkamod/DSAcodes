
import java.util.*;

public class Q503 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                nextGreaterElements(new int[]{1, 2, 3, 4, 3})
        ));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int N = nums.length;
        int[] arr = new int[N];
        for (int i = 2 * N - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums[i % N]) {
                stk.pop();
            }
            if (i < N) {
                arr[i] = stk.isEmpty() ? -1 : stk.peek();
            }
            stk.push(nums[i % N]);
        }
        return arr;
    }

    public static int[] nextGreaterElements2(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;

            if (j == nums.length) {
                j = 0;
            }

            while (j != nums.length && j != i) {
                if (nums[j] > nums[i]) {
                    arr[i] = nums[j];
                    break;
                }
                j++;
                if (j == nums.length) {
                    j = 0;
                }
            }
        }
        return arr;
    }
}
