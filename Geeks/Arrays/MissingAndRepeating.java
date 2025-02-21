import java.util.ArrayList;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,8,9,6} ;
        System.out.println(findTwoElement2(arr));
    }


    // optimal 1
    // tc : n
    // sc : 1
    static ArrayList<Integer> findTwoElement1(int arr[]) {
        // sum method 
        //      rep - mis = S - Sn  // where S is sum of elements and Sn is sum of 1 to n 
        // rep^2 + mis^2 = S2 - Sn2  // where S2 is sum of square of elements and Sn2 is sum of square of 1 to n 
        
        
        int n = arr.length ;
        
        long Sn = (long)  n*(n+1) / 2;
        long Sn2 = (long)  n*(n+1) * (2*n+1) / 6 ;
        
        long S = 0 ;
        long S2 = 0 ;
        
        for(int i=0 ;i<n ;i++){
            S += arr[i] ;
            S2 += (long) arr[i] * arr[i] ;
        }
        
        long val1 = S - Sn ;        // rep - mis
        long val2 = S2 - Sn2 ;  
        
        val2 = val2 / val1 ;        // rep + mis
        
        long rep = (val1 + val2) / 2 ;       // solving both equation  
        
        long mis = rep - val1 ;              
        
        ArrayList<Integer> list = new ArrayList<>() ;
        list.add((int)rep) ;
        list.add((int)mis) ;
        
        return list ;
    }

    // optimal 2
    // tc : 5n
    // sc : 1
    static ArrayList<Integer> findTwoElement2(int arr[]) {
        // xor method 
        int n = arr.length ;
        
        int xor = 0 ;
        for(int i = 0 ; i < n ; i++){
            xor = xor ^ arr[i] ;
            xor = xor ^ (i+1) ;
        }
        
        int bitNo = 0 ;
        
        while(true){
            if((xor & (1<<bitNo)) != 0){
                break ;
            }
            bitNo++ ;
        }
        
        int zero = 0 ;
        int one = 0 ;
        
        for(int i = 0 ; i < n ; i++){
            // one's club
            if((arr[i] & (1<<bitNo)) != 0){
                one = one ^ arr[i] ;
            }
            //zero's club
            else{
                zero = zero ^ arr[i] ;
            }
        }
        
        
        for(int i = 1 ; i <= n ; i++){
            // one's club
            if((i & (1<<bitNo)) != 0){
                one = one ^ i ;
            }
            //zero's club
            else{
                zero = zero ^ i ;
            }
        }
        
        int cnt = 0 ;
        int rep = 0 ;
        int mis = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == zero){
                cnt++ ;
            }
        }
        
        if(cnt == 2){
            rep = zero ;
            mis = one ;
        } else{
            rep = one ;
            mis = zero ;
        }
        
        
        
        ArrayList<Integer> list = new ArrayList<>() ;
        list.add((int)rep) ;
        list.add((int)mis) ;
        
        return list ;
    }

    // better
    // tc : 2n
    // sc : n+1
    ArrayList<Integer> findTwoElement3(int arr[]) {
        
        int n = arr.length ;
        
        int rep = -1 ;
        
        int mis = -1 ;
        
        int[] hash = new int[n+1] ;
        
        for(int i=0 ;i<n ;i++){
            
            hash[arr[i]]++ ;
        }
        
        for(int i = 1 ; i <= n ;i++){
            
            if(hash[i] == 0 ){
                mis = i ;
            }
            else if(hash[i] == 2){
                rep = i ;
            }
            if(rep != -1 && mis != -1){
                break ;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>() ;
        list.add(rep) ;
        list.add(mis) ;
        
        return list ;
    }
}
