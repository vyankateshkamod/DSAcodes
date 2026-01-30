
import java.util.HashMap;
import java.util.HashSet;

public class Q992 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{2,1,1,1,3,4,3,2}, 3));
    }

    // optimal
    // tc : 4n
    // sc : 2k
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return find(nums, k) - find(nums, k-1);
    }

    public static int find(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0, l = 0, r = 0;

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]) ;
                }
                l++;
            }
            
           
            cnt += r-l+1;
            
            r++;
        }
        return cnt;
    }

    // brute
    // tc : n2
    // sc : k
    public int subarraysWithKDistinct2(int[] nums, int k) {
        int n = nums.length ;
        HashSet<Integer> set ;
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            set = new HashSet<>();
            for(int j = i ; j < n ; j++){
                
                set.add(nums[j]);
                
                if(set.size() == k){
                    cnt++ ;
                }

                else if(set.size() > k){
                    break ;
                }

            }
        }
        return cnt ;
    }
}