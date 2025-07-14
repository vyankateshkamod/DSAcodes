import java.util.* ;
public class Q78 {
    public static void main(String[] args) {
        int[]nums = {1,2,3} ;
        for(List<Integer> list : subsets(nums)){
            System.out.println(list);
        }
    }

    // tc : 2^n * n
    // sc : 2^n * n
    public static  List<List<Integer>> subsets(int[] nums){
        int n = nums.length ;
        int subsets = 1 << n ;
        List<List<Integer>> ans = new ArrayList<>() ;

        for(int num = 1 ; num <= subsets ; num++){
            List<Integer> temp = new ArrayList<>() ;
            for(int i = 0 ; i < n ; i++){
                if((num & (1 << i)) != 0){
                    temp.add(nums[i]) ;
                }
            }
            ans.add(new ArrayList<>(temp)) ;
        }
        return ans ;
    }


    // my approach
    static List<List<Integer>> ans = new ArrayList<>() ;
    public static  List<List<Integer>> subsets2(int[] nums){
        int n = nums.length ;
        int pow = calPowofTwo(n) ;
        for(int i = 0 ; i < pow ; i++){
            createSubsets(i,nums,n) ;
        }
        return ans ;
    }

    public static int calPowofTwo(int n){
        int res = 1;
        while(n != 0){
            res = res * 2 ;
            n-- ;
        }
        return res ;
    }

    public static void createSubsets(int comb , int[]nums , int range){
        List<Integer> temp = new ArrayList<>() ;
        int tempRange = range ;
        int idx = 0 ;
        int one = 1 ;
        while(tempRange != 0){
            if((comb & one) > 0){
                temp.add(nums[idx]) ;
            }
            one = one << 1 ;
            idx++ ;
            tempRange-- ;
        }
        ans.add(new ArrayList<>(temp)) ;
    }

    public static int calRange(int n){
        int range = 0 ;
        while(n != 0){
            n = n/2 ;
            range++ ;
        }
        return range ;
    }
}