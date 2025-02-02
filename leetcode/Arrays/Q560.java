import java.util.HashMap;
import java.util.Map;

public class Q560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>() ;
        int res = 0 ;
        int cur = 0 ;
        map.put(0,1) ;
        for(int i : arr){
            cur = cur + i ;
            res = res + map.getOrDefault(cur - k, 0) ;
            map.put(  cur, map.getOrDefault(cur,0)+1  ) ;
        }
        return res ;
    }
}
