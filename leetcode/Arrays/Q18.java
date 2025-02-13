import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q18 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2} ;
        List<List<Integer>> list = new ArrayList<>(fourSum(nums, 0)) ;
        System.out.println(list);
    }

    // Optimal
    // tc : n3
    // sc : no.of quads

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums) ;
        List<List<Integer>> list = new ArrayList<>() ;
        
        for (int i = 0; i < n; i++) {

            if(i > 0 && nums[i] == nums[i-1]) continue ;

            for (int j = i + 1; j < n; j++) {

                if(j > i+1 && nums[j] == nums[j-1]) continue ;

                int k = j+1 ;
                int l = n-1 ;
                while(k < l){
                    long sum = nums[i] ;
                    sum = sum + nums[j] ;
                    sum = sum + nums[k] ;           // to avoid overflow condition
                    sum = sum + nums[l] ;
                    if(sum > target){
                        l-- ;
                    }
                    else if(sum < target){
                        k++ ;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k],nums[l]));
                        list.add(quad) ;
                        k++ ;
                        l-- ;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
               
            }
        }
        
        return list;
    }

    // Better
    // tc : n3 * log(m)
    // sc : n + 2(no.of quads)

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                Set<Long> hashset = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long sum = nums[i] ;
                    sum = sum + nums[j] ;
                    sum = sum +  nums[k] ;
                    long last = target - sum ;

                    if (hashset.contains(last)) {
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k],(int) last));
                        Collections.sort(quad);
                        set.add(quad);
                    }

                    hashset.add((long)nums[k]);

                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }



    // Brute
    // tc : n4
    // sc : 2(no.of quads)
    
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        int n = nums.length ;
        Set<List<Integer>> set = new HashSet<>() ;
        for(int i = 0; i<n ;i++){
            for(int j = i+1 ;j<n ;j++){     
                for(int k = j+1 ;k<n ;k++){
                    for(int l = k+1 ;l<n;l++){
                        long sum = nums[i] ;
                        sum  = sum + nums[j] ;
                        sum = sum + nums[k];
                        sum = sum + nums[l] ;
                        if(sum== target){
                            List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])) ;
                            Collections.sort(quad) ;
                            set.add(quad) ;
                        }
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set) ;
        return list ;
    }
}
