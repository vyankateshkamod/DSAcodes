// https://youtu.be/bfKwLi6jtDk?si=KaDNd1WkEoa2s9DW
import  java.util.* ;
public class Q40 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>() ;
        list = combinationSum(new int[]{10,1,2,7,6,1,5}, 8) ;
        for(List<Integer> temp : list){
            System.out.print(temp + ",");
        }
    }

    // tc : 2^n
    // sc : n
    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        int i = 0;
        solve(i, comb, ans, candidates, target);
        return ans;
    }

    public static  void solve(int i, List<Integer> comb, List<List<Integer>> ans, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }

        for (int idx = i; idx < candidates.length; idx++) {
            if (idx > i && candidates[idx] == candidates[idx - 1]) {
                continue; // skip duplicates
            }

            // do
            comb.add(candidates[idx]);
            // explore
            solve(idx + 1, comb, ans, candidates, target - candidates[idx]);
            // undo
            comb.remove(comb.size() - 1);
            // explore
            // solve(i + 1, comb, ans, candidates, target); // candidates array is sorted so we dont need this case 
        }

    }
}