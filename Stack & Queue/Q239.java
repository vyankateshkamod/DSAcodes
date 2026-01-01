
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3))));
    }

    // optimal
    // tc : n
    // sc : k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n-k+1] ;
        
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.removeLast();
            }
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            dq.addLast(i);
            if (!dq.isEmpty() && i >= k-1) {
                res[i-k+1] = nums[dq.peekFirst()] ;
            }
        }

        return res ;
    }


    // brute
    // tc : n*k
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length ;
        int[] ans = new int[n-k+1] ;
        int l = 0 ; 
        int r = k-1 ;
        while(r != n){
            ans[l] = findMax2(l,r,nums) ;
            l++ ;
            r++ ;
        }
        return ans ;
    }

    public static int findMax2(int l , int r , int[] nums){
        int maxValue = Integer.MIN_VALUE ;
        for(int i = l ; i <= r ; i++){
            maxValue = Math.max(maxValue , nums[i]) ;
        }
        return maxValue ;
    }
}