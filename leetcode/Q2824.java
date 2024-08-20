//Count Pairs Whose Sum is Less than Target

import java.util.List ;
import java.util.ArrayList ;
public class Q2824 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        System.out.println(countPairs(nums,2));
    }
    public static int countPairs(List<Integer> nums, int target) {
        int pair = 0;
        nums.sort((a,b) -> a-b) ;
        int l = 0;
        int r = nums.size() - 1 ;
        while(l != r){
            if(nums.get(l) + nums.get(r) < target){
                pair += r-l ;
                l++;
            }
            else{
                r-- ;
            }
        }
        return pair ;
    }
}
