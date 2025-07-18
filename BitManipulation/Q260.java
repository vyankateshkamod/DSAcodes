import java.util.* ;
public class Q260 {
    public static void main(String[] args) {
        int[] ans = singleNumber(new int[]{2,4,2,14,8,7,7,8}) ;
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    //optimal
    // tc : 2n 
    public static int[] singleNumber(int[] nums) {
        int xor = 0 ;
        for(int num : nums){
            xor = xor ^ num ;
        }
        
        xor = ((xor ^ (xor-1)) & xor) ;

        int bkt1 = 0 ; 
        int bkt2 = 0 ;
        for(int num : nums){
            if((num & xor) != 0){
                bkt1 = bkt1 ^ num ;
            }
            else{
                bkt2 = bkt2 ^ num ;
            }
        }

        return new int[]{bkt1 , bkt2} ;
    }

    // brute
    // m = n/2 + 1
    // tc : n log m + m
    // sc : m
    public int[] singleNumber2(int[] nums) {
        int first = -1 ;
        int second = -1 ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1) ;
        }

        for(Integer key : map.keySet()){
            if(map.get(key) == 1 && first == -1){
                first = key ;
                continue ;
            }
            if(map.get(key) == 1 && second == -1){
                second = key ;
            }
        }

        return new int[]{first,second} ;
    }
}