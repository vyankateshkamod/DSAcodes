import java.util.ArrayList;

public class Q2149 {
    public static void main(String[] args) {
        int []arr = rearrangeArray(new int[]{3,1,-2,-5,2,-4});
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    // Optimal
    // TC : O(n)
    // SC : O(n)
    public static int[] rearrangeArray(int[] nums) {
        int[] temp = new int[nums.length];
        int posidx = 0 ;
        int negidx = 1 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                temp[posidx] = nums[i];
                posidx += 2 ;
            } else {
                temp[negidx] = nums[i];
                negidx += 2 ;
            }
        }
        return temp;
    }

    // Brute
    // TC : O(2n)
    // SC : O(n)
    public static int[] rearrangeArray2(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>() ;
        ArrayList<Integer> temp2 = new ArrayList<>() ;
        int j = 0 ;
        int k = 0 ;
        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i] > 0){
                temp.add(nums[i]) ;
            }
            else{
                temp2.add(nums[i]) ;
            }
        }


        for(int i = 0 ; i < nums.length ;i++){
            if(i%2==0){
                nums[i] = temp.get(j++) ;
            }
            else{
                nums[i] = temp2.get(k++);
            }
            
        }
        return nums ;
    }
}
