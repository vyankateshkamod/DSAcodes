public class Q1248 {
    public static void main(String[] args) {
        System.out.print(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }

    // optimal
    // tc : 4n
    // sc : 1
    public static int numberOfSubarrays(int[] nums, int k) {
        return find(nums,k) - find(nums,k-1) ;
    }

    public static int find(int[] nums, int k){
        if(k < 0) return 0 ;
        int n = nums.length;
        int l = 0, r = 0 ;
        int SAcnt = 0;
        int Ocnt = 0;

        while(r < n){
            if (nums[r] % 2 == 1) {
                Ocnt++;
            }

            while(Ocnt > k){
                if(nums[l] % 2 == 1){
                    Ocnt-- ;
                }
                l++ ;
            }
            
            SAcnt += (r-l+1) ;
            
            r++;
        }
        

        return SAcnt;
    }

    // brute 
    // tc : n2
    // sc : 1
    public static int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length ;
        int SAcnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            int Ocnt = 0;
            for(int j = i ; j < n ; j++){
                if(nums[j] % 2 == 1){
                    Ocnt++;
                }
                if(Ocnt == k){
                    SAcnt++;
                }
                else if(Ocnt > k){
                    break ;
                }
            }
        }
        return SAcnt ;
    }
}