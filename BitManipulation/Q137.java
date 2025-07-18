public class Q137 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,1,2,3,2,3,2,3,4}));
    }

    // tc :  n
    public static int singleNumber(int[] nums) {
        int n = nums.length ;
        int ones = 0 ;
        int twos = 0 ;
        for(int i = 0 ; i < n ; i++){
            ones = (ones ^ nums[i]) & ~twos ;
            twos = (twos ^ nums[i]) & ~ones ;
        }
        return ones ;
    }

    // tc : 32 * n
    public static  int singleNumber2(int[] nums) {
        int n = nums.length ;
        int result = 0 ;
        for(int i = 0 ; i < 32 ; i++){
            int zeros = 0 ;
            int ones = 0 ;
            for(int num = 0 ; num < n ; num++){
                if((nums[num] & (1 << i)) == 0){
                    zeros++ ;
                }
                else{
                    ones++ ;
                }
            }
            if(ones % 3 != 0){
                result = (result | (1 << i)) ;
            }
        }
        return result ;
    }
}