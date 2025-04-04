import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubarraywithgivenXOR {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,2,2,6,4)) ;
        System.out.println(solve(list, 6));
        System.out.println(solve2(new int[] {4,2,2,6,4}, 6));
    }


    // Optimal 
    // TC : n logn
    // sc : n
    // used prefix xor 
    public static int solve(ArrayList<Integer> A, int B) {
        // xor = x ^ B
        // xor ^ B = x ^ B ^ B // xor B on both sides
        // x = xor ^ B // we get

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int n = A.size();
        int xor = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            xor ^= A.get(i);
            int x = xor ^ B;
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);

        }
        return cnt;
    }


    //Better
    // TC : n2
    public static int solve2(int[] A, int B) {
        int n = A.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int res = A[i];
            if (res == B) {
                cnt++;
            }
            for (int j = i + 1; j < n; j++) {
                res = res ^ A[j];
                if (res == B) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
