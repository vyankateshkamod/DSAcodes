import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = merge(intervals);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }

    //optimal
    // tc : nlogn + n
    // sc : n
    public static int[][] merge(int[][] arr) {
        int n = arr.length;

        List<int[]> result = new ArrayList<>();

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            if (result.isEmpty() || arr[i][0] > result.getLast()[1]) {
                result.add(arr[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], arr[i][1]);
            }

        }

        return result.toArray(new int[result.size()][]);
    }



    // better
    //tc : nlogn + 2n
    //sc : n
    public static int[][] merge2(int[][] arr) {
        int n = arr.length; 

        List<int[]> result = new ArrayList<>() ;

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0])) ;

        for(int i = 0 ;i<n ;i++){
            int start = arr[i][0] ;
            int end = arr[i][1] ;

            for(int j = i+1 ;j<n ;j++){
                if(arr[j][0] <= end){
                    end = Math.max(end,arr[j][1] );
                    i = j;
                }
                else{
                    break ;
                }
            }

            result.add(new int[]{start,end}) ;
        }

        return result.toArray(new int[result.size()][]) ;
    }
}
