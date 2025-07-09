public class CountNoOfSetBits {
    public static void main(String[] args) {
        System.out.println(setBits(6));
    }

    // tc : no.of set bits
    static int setBits(int n) {
        int cnt = 0 ;
        while(n > 0){
            n = (n & n-1) ;
            cnt++ ;
        }
        return cnt ;
    }

    // tc : log n
    static int setBits2(int n){
        int cnt = 0 ;
        while(n > 0){
            cnt += (n & 1) ;
            n = n >> 1 ;
        }
        return cnt ;
    }

    // tc : 32
    static int setBits3(int n) {
        int a = 1 ;
        int i = 0 ;
        int cnt = 0 ;
        while(i != 32){
            if((n & a) != 0){
                cnt++ ;
            }
            a = a << 1 ;
            i++ ;
        }
        return cnt ;
    }
}