import java.util.ArrayList ;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List ;
import java.util.Set;

public class Q15 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(threeSum(new int[]{-1,0,1,2,-1,-4})) ;
        System.out.println(list);
    }
    
    // Optimal
    // tc: nlogn + n2
    // sc : no.of unique triplets
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int k = nums.length - 1;

            int j = i + 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    ans.add(triplet);
                    j++ ;
                    k-- ;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        return ans;
    }

    // Better
    // tc: n2 * log(m)
    // sc : n + 2 * (no.of unique triplets)
    public List<List<Integer>> threeSum2(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                int k = -(nums[i] + nums[j]) ;

                if(hashset.contains(k)){
                    List<Integer> triplet = Arrays.asList(nums[i],nums[j],k) ;
                    Collections.sort(triplet) ;
                    set.add(triplet) ;
                }
                else{
                    hashset.add(nums[j]) ;
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    //Brute 
    //tc: n3 * log(no.of unique triplets)
    //sc : 2 * (no.of triplets)
    public List<List<Integer>> threeSum3(int[] nums) {

        Set<List<Integer>> set = new HashSet<>() ;

        for(int i = 0 ;i<nums.length ;i++){
            for(int j = i+1 ;j<nums.length;j++){
                for(int k = j+1 ;k<nums.length ;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> triplet = Arrays.asList(nums[i],nums[j],nums[k]) ;
                        Collections.sort(triplet) ;
                        set.add(triplet) ;
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(set) ;
        return list ;
    }
}
