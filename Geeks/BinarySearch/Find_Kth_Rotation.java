import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Kth_Rotation {
    public static void main(String[] args) {
        System.out.println(findKRotation(new ArrayList<>(Arrays.asList(5,6,1,2,3,4))));
    }

    public static int findKRotation(List<Integer> arr) {
        int n = arr.size() ;
        int low = 0 ;
        int high = n - 1 ;
        int min = Integer.MAX_VALUE ;
        int min_idx = -1 ;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            
            if(arr.get(low) <= arr.get(high)){
                if(arr.get(low) < min){
                    min = arr.get(low) ;
                    min_idx = low ;
                }
                break ;
            }
            
            if(arr.get(low) <= arr.get(mid)){
                low = mid + 1 ;
                if(arr.get(low) < min){
                    min = arr.get(low) ;
                    min_idx = low ;
                }
            }
            else{
                high = mid - 1 ;
                if(arr.get(mid) < min){
                    min = arr.get(mid) ;
                    min_idx = mid ;
                }
            }
        }
        return min_idx ;
    }
}
