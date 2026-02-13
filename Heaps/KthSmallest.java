
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[] nums = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        System.out.println(kthSmallest(nums, 4));
    }

    // using heap
    // tc : n logk
    // sc : k
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length ;
        for(int i = 0 ; i < n ; i++){
            Q.add(arr[i]);
            if(Q.size() > k){
                Q.poll();
            }
        }
        return Q.peek();
    }
}