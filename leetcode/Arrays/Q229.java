import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q229 {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 4, 2, 6, 2, 3 };
        List<Integer> result = majorityElement(nums);
        System.out.println("Optimal Approach: " + result);
    }

    // Optimal
    // tc :2n
    // sc :1
    // Boore moore voting algorithm
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        int maj1 = Integer.MIN_VALUE;
        int maj2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maj1) {
                cnt1++;
            } else if (nums[i] == maj2) {
                cnt2++;
            } else if (cnt1 == 0) {
                maj1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                maj2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Varification
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == maj1) {
                cnt1++;
            } else if (num == maj2) {
                cnt2++;
            }
        }

        if (cnt1 > n / 3) {
            list.add(maj1);
        }

        if (cnt2 > n / 3) {
            list.add(maj2);
        }
        return list;

    }

    // Better
    // tc :n
    // sc :n
    public static List<Integer> majorityElement2(int[] nums) {
        int n = nums.length;
        int min = nums.length / 3 + 1;

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == min) {
                list.add(nums[i]);
            }
            if (list.size() == 2) { // if array size is 8 then array of elements who are greater than 8/3 i.e 2 are
                                    // always be 2 . hence to avoid further iteration of arr.
                break;
            }
        }

        return list;

    }
}
