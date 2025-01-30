//  Remove Duplicates from Sorted Array

public class Q26 {
    public static void main(String[] args) {
        int[]nums = {1,2,3,4,4,5,6} ;
        removeDuplicates(nums);
        printarr(nums) ;
    }
    public static int removeDuplicates(int[] nums) {
        int unique = 1;
        for(int i=1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                unique += 1;
                nums[unique-1] = nums[i] ;
            }
        }
        return unique ;
    }
    public static void printarr(int[]nums){
        System.out.print("[") ;
        for(int i = 0 ; i < nums.length; i++){
            System.out.print(nums[i]+",");
        }
        System.out.print("]") ;
    }
}
