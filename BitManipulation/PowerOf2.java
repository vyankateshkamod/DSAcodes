public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerofTwo(32));
    }

    // tc : 1
    public static boolean isPowerofTwo(int n) {
        return (n & n-1) == 0 ;
    }

    // tc : log n
    public static boolean isPowerofTwo2(int n) {
        int a = 1 ;
        while((n & a) == 0){
            a = a << 1 ;
        }
        return (n & a) == n ;
    }
}