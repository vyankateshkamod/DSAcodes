import java.util.* ;
public class Q216 {
    public static void main(String[] args) {
        for(List<Integer> arr : combinationSum(3, 9)){
            System.out.println(arr);
        }
    }

    // tc : 2^9 * k
    // sc : k(recursive) + (combinations * k)
    public static  List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        solve(1, 0, comb, ans, k , n) ;
        return ans;
    }

    public static void solve(int start, int sum, List<Integer> comb, List<List<Integer>> ans, int k , int n) {
        if (sum == n && comb.size() == k) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (sum > n || comb.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            comb.add(i);
            solve(i + 1, sum + i, comb, ans, k , n);
            comb.remove(comb.size() - 1);
        }
    }

    // my version
    // tc : 2^9(combinations) * k(copy)
    // sc : k (recursive) + (valid combinations * k)
    public List<List<Integer>> combinationSum2(int k, int n) {
        int[] ks = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        solve(0, n, comb, ans, ks, k);
        return ans;
    }

    public static void solve(int i, int sum, List<Integer> comb, List<List<Integer>> ans, int[] ks, int k) {
        if (sum == 0 && comb.size() == k) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (sum < 0 || i == ks.length || comb.size() > k){
            return ;
        }

        comb.add(ks[i]);
        solve(i + 1, sum - ks[i], comb, ans, ks, k);
        comb.remove(comb.size() - 1);
        solve(i + 1, sum, comb, ans, ks, k);
    }
}