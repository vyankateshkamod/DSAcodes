// Prefix array method 

import java.util.Arrays ;
class  Q2090{
    public static void main(String[] args) {
        int[]array = {7,4,3,9,1,8,5,2,6} ;
        System.out.println(Arrays.toString(getAverages(array, 3)));
    }
    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length ;
        int[]res = new int[n] ;
        if(k==0){
            return nums ;
        }
        Arrays.fill(res,-1) ;
        if(n < 2*k+1){
            return res ;
        }
        long[]prefixSum = new long[n] ;
        Arrays.fill(prefixSum,0) ;
        prefixSum[0] = nums[0] ;
        for(int i = 1 ; i<n ; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i] ; 
        }

        for(int i = k ; i<n-k ;i++){
            int left_idx = i-k ;
            int right_idx = i+k ;
            long sum = prefixSum[right_idx];
            if(left_idx > 0){
                sum -= prefixSum[left_idx-1] ;
            }
            res[i] = (int) (sum/(2*k+1));
        }
        return res ;
    }
}