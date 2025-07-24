public class Q50 {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    // tc : log n
    public static double myPow(double x, int n) {
        long nn = n ;
        if(nn < 0){
            x = 1/x ;
            nn = -nn ;
        }
        
        double ans = 1 ;
        while(nn > 0){
            if(nn % 2 == 0){
                x = x * x ;
                nn = nn/2;
            }
            else{
                ans = ans * x ;
                nn = nn-1;
            }
        }
        return ans ;
    }
}