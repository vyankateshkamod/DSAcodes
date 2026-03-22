
import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4};
        nearlySorted(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    // tc : n log k
    // sc : k
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        int n = arr.length ;
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            Q.add(arr[i]);
            if(Q.size() > k){
                arr[j] = Q.poll();
                j++;
            }
        }
        while(Q.size() > 0){
            arr[j] = Q.poll();
            j++;
        }
    }
}