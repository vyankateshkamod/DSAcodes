
import java.util.PriorityQueue;

public class MinCostConnectRopes {

    public static void main(String[] args) {
        int ans = minCost(new int[] {4, 3, 2, 6});
        System.out.println(ans);
    }

    public static  int minCost(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : arr) {
            pq.add(e);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            cost = cost + sum;
            pq.add(sum);
        }
        return cost;
    }

}
