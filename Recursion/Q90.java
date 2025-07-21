// https://youtu.be/pNzljlzDCiI?si=Qult3poseTrSfH5p

import java.util.* ;
public class Q90 {
    public static void main(String[] args) {
        for(List<Integer> arr : subsetsWithDup( new int[]{1,2,2})){
            System.out.println(arr);
        }
    }

    // tc : n log n(sorting) + 2^n(unique subsets) * n(to copy subset into the allSubsets)
    // sc : n(recursive) + 2^n * n(allSubsets * subset)
    public static  List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, subset , allSubsets);
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
        int idx = i+1 ;
        while(idx < nums.length && nums[idx] == nums[idx-1]){
            idx++ ;
        }
        solve(idx, nums, subset, allSubsets);
    }
}