import java.util.ArrayList ;
import java.util.List ;

public class Q78 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>() ;
        arr = subsets(new int[] {1,2,3}) ;
        for(List<Integer> set : arr){
            System.out.println(set);
        }
    }

    // tc : 2^n * n
    // sc : n(recursive) + 2^n * n (allSubsets)
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        solve(0, nums, subset, allSubsets);
        return allSubsets;
    }

    public static void solve(int i, int[] nums, List<Integer> subset, List<List<Integer>> allSubsets) {
        if (i == nums.length) {
            allSubsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        solve(i + 1, nums, subset, allSubsets);
        subset.remove(subset.size() - 1);
        solve(i + 1, nums, subset, allSubsets);
    }
}