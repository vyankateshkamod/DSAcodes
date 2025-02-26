
import java.util.Arrays;

public class CeilTheFloor {
    public static void main(String[] args) {
        int[]arr = {5, 6, 8, 9, 6, 5, 5, 6} ;
        System.out.println(Arrays.toString(getFloorAndCeil(7,arr )));
    }

    // tc : n
    public static int[] getFloorAndCeil(int x, int[] arr) {
        int n = arr.length ;
    
        int floor = -1 ;
        int ceil = -1 ;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] < x){
                floor = Math.max(floor,arr[i]) ;
            }
            else if(arr[i] > x){
                if(ceil == -1){
                    ceil = arr[i] ;
                }
                else{
                    ceil = Math.min(ceil,arr[i]) ;
                }
            }
            else{
                floor = arr[i] ;
                ceil  = arr[i] ;
                return new int[]{floor,ceil} ;
            }
        }
        
        return new int[]{floor,ceil} ;
    }
}
