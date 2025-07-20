public class Q29 {
    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }

    // tc : (log n)2
    public static int divide(int dividend, int divisor) {
        if(dividend == divisor){
            return 1 ;
        }
        boolean sign = true ;
        if(dividend < 0 && divisor >= 0){
            sign = false ;
        }
        else if(dividend >= 0 && divisor < 0){
            sign = false ;
        }
        long n = Math.abs((long)dividend) ;
        long d = Math.abs((long)divisor) ;
        long ans = 0 ;
        long cnt = 0 ;
        while(n >= d){

            while(n >= (d << cnt)){
                cnt++ ;
            }
            cnt-- ;
            ans = ans + (1L<<cnt);
            n = n - (d<<cnt);
            cnt = 0;
            
        }

        if(sign == false){
            ans = (-1 * ans) ;
        }

        if(ans >= Integer.MAX_VALUE){
            ans = Integer.MAX_VALUE ;
        }
        else if(ans <= Integer.MIN_VALUE){
            ans = Integer.MIN_VALUE ;
        }


        return (int)ans ;
    }
}