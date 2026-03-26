
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q846 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }

    // Ordered Map(Tree Map)
    // tc : n log n
    // sc : n
    public static boolean isNStraightHand2(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int value : hand) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        while (!map.isEmpty()) {
            int start = map.firstKey();
            for(int i = 0 ; i < groupSize ; i++){
                int curr = start + i;
                if(!map.containsKey(curr)) return false;
                map.put(curr, map.get(curr)-1);
                if(map.get(curr) == 0){
                    map.remove(curr);
                }
            }
        }

        return true;
    }

    // Priority Queue
    // tc : n log n
    // sc : n
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int value : hand) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        PriorityQueue<Integer> Q = new PriorityQueue<>(map.keySet());

        while (!Q.isEmpty()) {
            int start = Q.peek();
            for(int i = 0 ; i < groupSize ; i++){
                int curr = start + i;
                if(!map.containsKey(curr)) return false;
                map.put(curr, map.get(curr)-1);
                if(map.get(curr) == 0){
                    if(Q.peek() != curr) return false;
                    Q.poll();
                    map.remove(curr);
                }
            }
        }

        return true;
    }
}
