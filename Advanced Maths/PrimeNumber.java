// prime number is number having only two divisors (1 & itself)

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(13));
    }

    // tc : sqrt n
    static boolean isPrime(int n) {
        int cnt = 0 ;
        for(int i = 1 ; i*i <= n ; i++){
            if(n % i == 0){
                cnt++ ;
                if(n/i != i){
                    cnt++ ;
                }
            }
            if(cnt > 2){
                break ;
            }
        }
        
        if(cnt == 2){
            return true ;
        }
    
        return false ;
    }
}