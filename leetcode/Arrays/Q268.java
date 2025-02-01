import java.util.ArrayList;
import java.util.Arrays;

public class Q268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
    public static int missingNumber(int[] nums) {
        int xor1 = 0 ;
        int xor2 = 0 ;
        for(int i = 0 ; i<nums.length ;i++){
            xor2 = xor2 ^ nums[i] ;
            xor1 = xor1 ^ (i+1) ;
        }
        return xor1 ^ xor2 ;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0 ;
        for(int i = 0 ; i<=nums.length ;i++){
            sum = sum + i;
        }
        
        int sum2 = 0 ;
        for(int i = 0 ; i<nums.length ;i++){
            sum2 = sum2 + nums[i] ;
        }

        return sum - sum2 ;
    }

    public int missingNumber3(int[] nums) {
        
        int[]temp = new int[nums.length+1] ;
        Arrays.fill(temp,0) ;

        
        for(int i=0;  i< nums.length ;i++){
            temp[nums[i]] = 1 ;
        }
        int i = 0 ;
        for( i = 0 ;i<=temp.length ;i++){
            if(temp[i]==0){
                break ;
            }
        } 
        return i ;
    }

    public int missingNumber4(int[] nums) {
        ArrayList<Integer> list  = new ArrayList<>() ;
        for(int num : nums){
            list.add(num) ;
        }
        int i = 0 ;
        for(i=0;  i<= nums.length ;i++){
            if(!list.contains(i)){
                break ;
            }
        }
        return i ;
    }

    public int missingNumber5(int[] nums) {
        int i = 0 ;
        for(i = 0 ; i<= nums.length ;i++){
            boolean flag = false ;    
            for(int j = 0 ; j<nums.length ;j++){
                if(nums[j] == i){
                    flag = true ;
                    break ;
                }
            }
            if(flag==false){
                return i ;
            }
       }
       return i ;
    }
}
