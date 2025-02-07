import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
    //Optimal
    // tc : 2n
    // sc : n
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>() ;
        for(int i = 0 ;i<nums.length ;i++){
            set.add(nums[i]) ;
        }

        int max = 0 ;
        for(int e : set){
            if(!set.contains(e-1)){
                int cnt = 1 ;
                int x = e ;
                while(set.contains(x+1)){
                    cnt++ ;
                    x++ ;
                }
                max = Math.max(max,cnt) ;
            }
            
        }
        return max ;
    }

    //Better
    // tc : nlogn + n
    // sc : 1
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 0){
            return 0 ;
        }
        if(nums.length ==1){
            return 1 ;
        }
        Arrays.sort(nums) ;
        int max = 1 ;
        int cnt = 1;
        for(int i = 1 ; i < nums.length ;i++){

            if(nums[i] == nums[i-1]+1){
                cnt++ ;
            }
            else if(nums[i] != nums[i-1]){
                max = Math.max(max,cnt);
                cnt = 1 ;
            }
            
        }
        max = Math.max(max,cnt) ;
        return max ;
    }

    //Brute
    //tc : n2
    //sc : 1
    public int longestConsecutive3(int[] nums) {
        int max = 0 ;
        for(int i = 0 ; i < nums.length ;i++){
            int x = nums[i] ;
            int cnt = 1 ;
            while(ls(nums,x+1)==true){
                x++ ;
                cnt++ ;
            }
            max = Math.max(max,cnt) ;
            cnt = 0 ; 
        }
        return max ;
    }

    public boolean ls(int[] nums,int num){
        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i]==num){
                return true ;
            }
        }
        return false ;
    }

}
