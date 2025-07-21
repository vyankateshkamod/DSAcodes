
public class CheckifthereexistsasubsequencewithsumK {

    public static void main(String[] args) {
        System.out.println(checkSubsequenceSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    // recursive
    // tc : 2^n
    // sc : n
    public static boolean checkSubsequenceSum(int[] arr, int K) {
        int i = 0;
        int sum = 0;
        return solve(i, sum, arr, K);
    }

    public static boolean solve(int i, int sum, int[] arr, int k) {
        if (i == arr.length) {
            if (sum == k) {
                return true;
            } else {
                return false;
            }
        }

        sum = sum + arr[i];
        if (solve(i + 1, sum, arr, k) == true) {
            return true;
        };

        sum = sum - arr[i];
        if (solve(i + 1, sum, arr, k) == true) {
            return true;
        };

        return false;
    }
}
