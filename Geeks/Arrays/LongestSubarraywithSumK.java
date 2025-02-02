import java.util.HashMap;
import java.util.Map;

public class LongestSubarraywithSumK {
    public static void main(String[] args) {
        System.out.println(longestSubarray2(new int[]{10, 5, 2, 7, 1, -10}, 15));
    }

    public static int longestSubarray2(int[] arr, int k) {
        int sum = 0 ;
        int len = 0 ; 
        
        Map<Integer,Integer> map = new HashMap<>() ;
        
        for(int i = 0 ; i < arr.length ;i++){
            sum = sum + arr[i] ;
            
            if(sum==k){
                len = Math.max(len , i+1) ;
            }
            
            if(!map.containsKey(sum)){
                map.put(sum,i) ;
            }
                
            
            if(map.containsKey(sum-k)){
                len = Math.max(len,i-map.get(sum-k)) ;
            }
            
        }
        return len ;
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
