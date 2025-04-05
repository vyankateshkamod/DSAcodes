public class Q1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }
    // optimal 
    // tc : log n 
    public static  int findKthPositive(int[] arr, int k) {
        int n = arr.length ;
        int low = 0 ;
        int high = n-1 ;
        while(low <= high){
            int mid = low + (high-low)/2 ;
            int missing_numbers = arr[mid] - (mid+1) ;
            if(missing_numbers < k){
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        int ans = low + k ;
        return ans ;
    }
    // brute 
    // tc : n
    public static  int findKthPositive2(int[] arr, int k) {
        int n = arr.length ;
        if(arr[0] > k) return k ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > k){
                break ;
            }
            else{
                k++ ;
            }
        }
        return k ;
    }
}
