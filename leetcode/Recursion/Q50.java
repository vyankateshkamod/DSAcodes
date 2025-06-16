public class Q50{
    public static void main(String[] args) {
        System.out.print(myPow(2.0, 10));
    }


    // optimal
    // tc : log n
    // sc : log n  recursive stack space
    public static  double myPow(double x, int n) {
        double N = n ;
        double result = 1 ;
        if(N < 0){
            x = 1/x ;
            N = -N ;
        }
        return helper(x , N , result) ;
    }

    public static  double helper(double x , double n , double result){
        if(n == 0){
            return result ;
        }
        if(n % 2 == 0){
            x = x * x ;
            n = n/2 ;
        }
        else if(n % 2 != 0){
            result = result * x ;
            n = n-1 ;
        }
        
        return helper(x , n , result) ;
    }

    // brute 
    // tc : n
    // sc : n (recursive stack)
    // this solution will failed on large 'n' , crosses the limit of recursive stack
    public static  double myPow2(double x, int n) {
        double result = 1 ;
        boolean isNegative = false ;
        if(n <= 0){
            n = n * (-1) ;
            isNegative = true ;
        }
        result = helper(x , n , result) ;
        if(isNegative){
            result = 1/result ;
        }
        return result ;
    }

    public static  double helper(double x , int n , double result){
        if(n <= 0){
            return result ;
        }
        double check = (double) result * x ;
        if(check > Integer.MAX_VALUE){
            return Integer.MAX_VALUE ;
        }

        result = result * x ;
        return helper(x , n-1 , result) ;
    }
}