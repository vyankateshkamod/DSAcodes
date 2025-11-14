import java.util.* ;

public class Q907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[] {3,1,2,4}));
    }

    // optimal
    // tc : 5n
    // sc : 5n
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length ;
        int [] pse = findPse(arr) ;
        int [] nse = findNse(arr) ;
        long total = 0 ;
        long mod = 1000000007 ;

        for(int i = 0 ; i < n ; i++){
            long left = i - pse[i] ;
            long right = nse[i] - i ;
            long contribution = (left * right) % mod ;
            contribution = (contribution * arr[i]) % mod ;
            total = (total + contribution) % mod ;
        }
        return (int)total ;
    }

    public static  int[] findPse(int[] arr){
        int [] pse = new int[arr.length] ;
        Stack<Integer> stk = new Stack<>() ;
        for(int i = 0 ; i < arr.length ; i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                stk.pop() ;
            }
            pse[i] = stk.isEmpty() ? -1 : stk.peek() ;
            stk.push(i) ;
        }
        return pse ;
    }

    public static  int[] findNse(int[] arr){
        int n = arr.length ;
        int [] nse = new int[n] ;
        Stack<Integer> stk = new Stack<>() ;
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop() ;
            }
            nse[i] = stk.isEmpty() ? n : stk.peek() ;
            stk.push(i) ;
        }
        return nse ;
    }


    public static  int sumSubarrayMins2(int[] arr) {
        int n = arr.length ;
        long sum = 0 ;
        for(int i = 0 ; i < n ; i++){
            int min = arr[i] ;
            for(int j = i ; j < n ; j++){
                min = Math.min(min , arr[j]) ;
                sum += min ;
            }
        }
        // return (int)(sum % 1000000007);
        return (int)(sum % (1e9 + 7));
    }
}