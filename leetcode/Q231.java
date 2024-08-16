public class Q231 {
    public static void main(String[] args) {
        System.out.println(isPowerofTwo(16));
        System.out.println(isPowerofTwo2(5));
    }

    private static boolean isPowerofTwo2(int n){    // bitwise approach
        if(n==0){
            return false ;
        }
        long x = (long)n ;
        return (x & (-x)) == x ;                    // O(1) time complexity
    }

    private static boolean isPowerofTwo(int n) {    // Mathmatical Approach
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;                  // O(logn) time complexity
        }
        return n == 1;

    }
}
