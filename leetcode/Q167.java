//Two Sum II - Input Array Is Sorted

import java.util.Arrays;

public class Q167 {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6} ;
        System.out.print(Arrays.toString(twoSum(arr,9)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length-1;
        int l = 0 ;
        int r = n ;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
               return new int[]{l+1,r+1} ;
            }
            else if(numbers[l] + numbers[r] > target){
                r-- ;
            }
            else if(numbers[l] + numbers[r] < target){
                l++ ;
            }
        }
        
       return null;
    }
}
