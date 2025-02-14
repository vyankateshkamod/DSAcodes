import java.util.HashMap;

public class Largestsubarraywith0sum {
    public static void main(String[] args) {
        System.out.println(maxLen2(new int[] { 15, -2, 2, -8, 1, 7, 10, 23 }));
    }

    // Optimal
    // Tc : n logn // logn because we are using hashmap
    // sc : n
    static int maxLen(int arr[]) {
        int n = arr.length;
        int sum = 0; // 15 -2 2 -8 1 7 10 23
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                len = Math.max(len, i + 1);
            } else {
                if (map.containsKey(sum)) {
                    len = Math.max(len, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }

        }

        return len;
    }

    //Brute
    //tc : n2
    //sc : 1
    static int maxLen2(int arr[]) {
        int n = arr.length ;
                                            
        int len = 0 ;
        for(int i = 0 ;i<n;i++){
            int sum = 0 ;
            
            for(int j = i ;j<n;j++){
                sum += arr[j] ;
                if(sum == 0){
                    len = Math.max(len,j-i+1) ;
                }
            }
        }
        
        return len ;
    }
}
