public class Q930 {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
    }

    // optimal
    // tc : 4n
    // sc : 1
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return find(nums, goal) - find(nums, goal-1);
    }

    public static int find(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length ;
        int l = 0 , r = 0 , cnt = 0, sum = 0 ; 
        while(r < n){
            sum += nums[r] ;
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            cnt = cnt + r-l+1 ;
            r++;
        }
        return cnt ;
    }

    // brute
    // tc : n2
    // sc : 1
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int n = nums.length ;
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            int sum = 0 ; 
            for(int j = i ; j < n ; j++){
                sum += nums[j] ;
                if(sum == goal){
                    cnt++;
                } 
                else if(sum > goal){
                    break ;
                }
            }
        }

        return cnt ;
    }
}