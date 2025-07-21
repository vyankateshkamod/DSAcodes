import java.util.* ;
public class PrimeFactors {
    public static void main(String[] args) {
        System.out.println(primeFac(814));
    }


    // tc : sqrt n * log n
    // sc : number of prime factors
    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> factors = new ArrayList<>() ;
        for(int i = 2 ; i*i <= n ; i++){
            if(n % i == 0){
                factors.add(i) ;
                while(n % i == 0){
                    n = n/i ;
                }
            }
        }
        
        if(n > 1){
            factors.add(n) ;
        }
        return factors ;
    }

    // better   
    // tc : 2 * sqrt n * sqrt n
    // sc : number of prime factors
    public static ArrayList<Integer> primeFac2(int n) {
        ArrayList<Integer> factors = new ArrayList<>() ;
        for(int i = 1 ; i*i <= n ; i++){
            if(n % i == 0){
                if(isPrime(i)){
                    factors.add(i) ;
                }
                int x = n/i ;
                if(x != i){
                    if(isPrime(x)){
                        factors.add(x) ;
                    }
                }
            }
        }
        
      
        return factors ;
    }
    
    public static boolean isPrime(int n){
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