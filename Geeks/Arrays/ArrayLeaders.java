import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static void main(String[] args) {
        int[]arr = {16, 17, 4, 3, 5, 2} ;
        ArrayList<Integer> list = new ArrayList<>(leaders(arr)) ;
        for(int i:list){
            System.out.print(i+" ");
        }
    }

    // Optimal
    // TC : 2n
    // SC : n 
    public static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length ;
        ArrayList<Integer> list = new ArrayList<>() ;
        int max = -1 ;
        for(int i = n-1 ;i >= 0 ;i--){
            max = Math.max(max,arr[i]) ;
            if(arr[i] >= max){
                list.add(arr[i]) ;
            }
        }
        
        Collections.reverse(list) ;
        return list ;
    }

    // Brute
    // TC : n2
    // SC : n
    public static ArrayList<Integer> leaders2(int arr[]){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<arr.length ;i++){
            boolean leader = true ;
            for(int j = i+1 ;j<arr.length ;j++){
                if(arr[j] <= arr[i]){
                    leader = true ;
                }
                else{
                    leader = false ;
                    break ;
                }
            }
            if(leader!= false){
                list.add(arr[i]) ;
            }
        }
        return list ;
    }
}
