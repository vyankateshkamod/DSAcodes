import java.util.*;
public class Q204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    //optimal
    // tc : n + n log(log n) + n
    public static  int countPrimes(int m) {
        int[] arr = new int[m+1];
        Arrays.fill(arr,1);
        for(int i = 2 ; i*i <= m ; i++){
            if(arr[i] == 1){
                for(int j = i*i ; j <= m ; j = j+i){
                    arr[j] = 0;
                }
            }
        }

        int cnt = 0 ;
        for(int i = 2 ; i < m ; i++){
            if(arr[i] == 1){
                cnt++;
            }
        }
        return cnt ;
    }

    //better
    public static  int countPrimes2(int m) {
        int[] arr = new int[m+1];
        Arrays.fill(arr,1);
        for(int i = 2 ; i <= m ; i++){
            if(arr[i] == 1){
                for(int j = 2 ; j*i <= m ; j++){
                    arr[i*j] = 0;
                }
            }
        }

        int cnt = 0 ;
        for(int i = 2 ; i < m ; i++){
            if(arr[i] == 1){
                cnt++;
            }
        }
        return cnt ;
    }

    //brute
    // tc : m * sqrt n
    public static  int countPrimes3(int m) {
        int cnt = 0 ;
        for(int i = 0 ; i < m ; i++){
            if(isPrime(i)){
                cnt++;
            }
        }
        return cnt ;
    }

    public static  boolean isPrime(int n){
        int divisor = 0 ;
        for(int i = 1 ; i*i <= n ; i++){
            if(n%i == 0){
                divisor++;
                int x = n / i ;
                if(x != i){
                    divisor++;
                }
            }
            if(divisor > 2){
                break ;
            }
        }
        return divisor == 2;
    }
}