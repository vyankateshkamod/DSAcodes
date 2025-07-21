import java.util.* ;
public class AlldivisorsofaNumber {
    public static void main(String[] args) {
        print_divisors(36);
    }

    // tc : sqrt n
    // sc : sqrt n
    public static void print_divisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>() ;
        for(int i = 1 ; i*i <= n ; i++){
            if(n % i == 0){
                divisors.add(i);
                if(n/i != i){
                    int x = n / i ;
                    divisors.add(x);
                }
            }
        }
        
        Collections.sort(divisors) ;
        
        for(Integer divisor : divisors){
            System.out.print(divisor+" ") ;
        }
    }
}