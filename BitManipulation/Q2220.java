
public class Q2220 {

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
    }

    // tc : k(no. of set bits in ans)
    public static int minBitFlips(int start, int goal) {
        int ans = (start ^ goal) ;
        int cnt = 0 ;
        while(ans != 0){
            ans = (ans & (ans-1)) ;
            cnt++ ;
        }
        return cnt ;
    }

    // tc : log n
    public static  int minBitFlips2(int start, int goal) {
        int ans = (start ^ goal) ;
        int temp = ans ;
        int cnt = 0 ;
        int one = 1 ;
        int bitFlips = 0 ;

        while(temp != 0){
            temp = temp / 2 ;
            cnt ++ ;
        }

        for(int i = 0 ; i < cnt ; i++){
            if((ans & one) > 0){
                bitFlips++ ;
            }
            one = one << 1 ;
        }

        return bitFlips ;
    }

    // tc : 31
    public static int minBitFlips3(int start, int goal) {
        int a = (start ^ goal);
        int b = 1;
        int c = 0;
        int cnt = 0;
        while (a > 0) {
            if ((a & b) > 0) {
                cnt++;
            }
            b = b << 1;
            c++;
        }
        return cnt;
    }
}
