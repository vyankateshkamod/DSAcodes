//2260. Minimum Consecutive Cards to Pick Up

import java.util.HashMap;
import java.util.Map;

public class Q2260 {
    public static void main(String[] args){
        Q2260 obj = new Q2260() ;
        System.out.println(obj.minimumCardPickup(new int[]{3,4,2,3,4,7}));
    }
     public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>() ;
        int size = Integer.MAX_VALUE ;
        for(int i = 0 ; i < cards.length ; i++){
            if(map.containsKey(cards[i])){
                size = Math.min(size , i - map.get(cards[i]) + 1);
            }
            map.put(cards[i] , i) ;
        }
        return size == Integer.MAX_VALUE ? -1 : size ;
    }



    // public int minimumCardPickup(int[] cards) {
    //     //TC = O(n)
    //     // SC = O(1)
    //     int[]arr = new int[10000001] ;
    //     Arrays.fill(arr,-1) ;
    //     int size = Integer.MAX_VALUE;
    //     for(int i = 0 ; i < cards.length ; i++){
    //         if(arr[cards[i]] != -1){
    //             size =Math.min(size, i- arr[cards[i]] + 1)  ;
    //         }
    //         arr[cards[i]] = i ;
    //     }
    //     return size == Integer.MAX_VALUE ? -1 : size ;
    // }
}
