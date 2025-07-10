public class Q231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }

    // tc : 1
    public static  boolean isPowerOfTwo(int n) {
        if(n <= 0) return false ;
        return ((n & n-1) == 0) ;
    }

    // tc : log n
    public static  boolean isPowerOfTwo2(int n) {
        if(n <= 0) return false ;
        int a = 1 ;
        while((n & a) == 0){
            a = a << 1;
        }
        return (n & a) == n ;
    }
}