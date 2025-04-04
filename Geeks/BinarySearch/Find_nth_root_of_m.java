public class Find_nth_root_of_m {
    public static void main(String[] args) {
        System.out.println(nthRoot(3, 27));
    }
    // tc : (log m) * n => n log m
    public static  int nthRoot(int n, int m) {
        int low = 1 ;
        int high = m ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            int midN = func(mid,m,n) ;
            if(midN == 1){
                return mid ;
            }
            else if(midN == 0){
                low = mid + 1 ;
            }
            else if(midN == 2){
                high = mid - 1 ;
            }
        }
        return -1 ;
    }
    
    public static  int func(int mid , int m , int n){
        int ans = 1 ;
        for(int i = 1 ; i <= n ;i++){
            ans = ans * mid ;
            if(ans > m) return 2 ;
        }
        if(ans == m) return 1 ;
        return 0 ;
    }
}
