public class LongestSubarraywithSumK {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10, 5, 2, 7, 1, -10}, 15));
    }

    public static int longestSubarray(int[] arr, int k) {
        
        int len = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            int sum = 0 ;
            
            for(int j = i ; j<arr.length ;j++){
               sum = sum + arr[j] ;
               if(sum == k){
                   len = Math.max(len,j - i + 1) ;
               }
            }
        }
        return len ;
        
    }
}
