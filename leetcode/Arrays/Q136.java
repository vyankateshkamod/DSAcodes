import java.util.HashMap;

public class Q136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,2,3,2,3,4,5,6,6,5}));
    }


    //Optimal
    public static  int singleNumber(int[] nums) {
        int xor = 0 ;
        for(int i = 0 ;i<nums.length ;i++){
            xor = xor ^ nums[i] ;
        }
        return xor ;
    }


    //Better
    //for all integers 
    public int singleNumber2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>() ;

        for(int i =0 ; i<nums.length ;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1) ;
            }
            else{
                map.put(nums[i],1) ;
            }
        }

        for(int i = 0 ;i < nums.length ; i++){
            if(map.get(nums[i])==1){
                return nums[i] ;
            }
        }
        return -1 ;
    }

    //Better
    //only for positive integers
    public int singleNumber3(int[] nums) {
        int max = 0 ;
        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i] > max){
                max = nums[i] ;
            }
        }
        int temp[] = new int[max+1] ;

        for(int i = 0 ; i<nums.length ;i++){
            temp[nums[i]]++ ;
        }

        int i = 0 ;    
        for(i = 0 ;i<temp.length ;i++){
            if(temp[i]==1){
                return i ;
            }
        }

        return -1 ;
    }


    //Brute
    public int singleNumber4(int[] nums) {
        int i = 0 ;
        for(i = 0 ;i<nums.length ;i++){
            int cnt = 0 ;
            int num = nums[i] ;
            for(int j = 0 ;j<nums.length ;j++){
                if(nums[j]==num){
                    cnt++ ;
                }
            }
            if(cnt == 1){
                return num ;
            }
        }
        return -1 ;
    }
}
