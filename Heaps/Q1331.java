
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Q1331 {
    public static void main(String[] args) {
        int[] arr = new int[]{40,10,20,30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    // optimal(Hashmap)
    // tc : n log n
    // sc : n

    public static int[] arrayRankTransform2(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;

        for(int num : temp){
            if(!map.containsKey(num)){
                map.put(num, rank);
                rank++;
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

    // better(priority queue)
    // tc : n log n
    // sc : n
    static class Pair{
        int value;
        int index;
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Pair> Q = new PriorityQueue<>((a,b)->(a.value - b.value));
        for(int i = 0 ; i < arr.length ; i++){
            Q.add(new Pair(arr[i],i));
        }

        int rank = 0;
        int prev = Integer.MIN_VALUE;

        while(!Q.isEmpty()){
            Pair pair = Q.poll();
            if(prev != pair.value){
                rank++;
            }
            prev = pair.value;
            arr[pair.index] = rank;
        }

        return arr;
    }


    // brute
    // tc : n2
    // sc : n
    public static int[] arrayRankTransform3(int[] arr) {
        int[] res = new int[arr.length];

        HashSet<Integer> set = new HashSet<>();

        for(int element : arr){
            set.add(element);
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            int rank = 1;
            for(int element : set){
                if(arr[i] > element){
                    rank++;
                }
            }
            res[i] = rank;
        }

        return res;
    }
}