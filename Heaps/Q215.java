
import java.util.PriorityQueue;

public class Q215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        int n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            Q.add(nums[i]);
            if(Q.size() > k){
                Q.poll();
            }
        }
        return Q.peek();
    }
}