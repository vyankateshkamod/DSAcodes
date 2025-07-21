public class Q1922{
    public static void main(String[] args) {
        System.out.print(countGoodNumbers2(4));
    }

    // tc : log n
    // sc : lon n
    public static  int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;
        long mod = 1_000_000_007;
        long result = 1;

        long evenDigits = power(5, evenPositions , result , mod);
        long oddDigits = power(4, oddPositions , result , mod);


        return (int) ((evenDigits * oddDigits) % mod);
    }

    public static  int power(long x, long exp , long result , long mod) {
        if(exp <= 0) return (int)result ;        

        if (exp % 2 == 0) {
            x = (x * x) % mod;
            exp = exp / 2;
        } else if (exp % 2 == 1) {
            result = (result * x) % mod;
            exp = exp - 1;
        }

        return power(x , exp , result , mod) ;
    }

    public static  int countGoodNumbers2(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;
        long mod = 1_000_000_007 ;

        long evenDigits = power(5, evenPositions);
        long oddDigits = power(4, oddPositions);

        return (int) ((evenDigits * oddDigits) % mod);
    }

    public static  int power(long x, long exp) {
        
        long result = 1;
        long mod = 1_000_000_007 ;
        x = x % mod ;
        while (exp > 0) {
            if (exp % 2 == 0) {
                x = (x * x) % mod;
                exp = exp / 2;
            } else if (exp % 2 == 1) {
                result = (result * x) % mod;
                exp = exp - 1 ;
            }
        }

        return (int) result;
    }
}