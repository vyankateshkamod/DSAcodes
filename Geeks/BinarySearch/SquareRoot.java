public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(floorSqrt(26));
    }

    // tc : log n
    static int floorSqrt(int n) {
        int ans = 1 ;
        int low = 1 ;
        int high = n ;
        while (low <= high){
            int mid = low + (high-low)/2 ;
            if(mid * mid <= n){
                ans = mid ;
                low = mid + 1 ;
            }
            else{
                high = mid -1 ;
            }
        }
        return ans ;
    }

    // tc : n
    int floorSqrt2(int n) {
        int ans = 1 ;
        for(int i = 0 ; i <= n ; i++){
           if(i * i <= n){
               ans = i ;
           }
           else{
               break ;
           }
        }
        return ans ;
    }
}
