import java.util.ArrayList;

public class Q283 {
    public static void main(String[] args) {
        int []arr = {1,0,3,0,5,0,7} ;
        moveZeroesOptimal(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    //Optimal Solution
    //TC : O(n)
    //SC : O(1)
    public static void moveZeroesOptimal(int[] arr) {
        int n = arr.length ; 
        
        int j = -1 ;

        for(int i=0 ;i<n ;i++){
            if(arr[i] == 0){
                j = i ;
                break ;
            }
        }

        if(j==-1){
            return ;
        }

        for(int i = j + 1 ; i < n ; i++){

            if(arr[i]!=0){
                int temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
                j++ ;
            }
            
        }

    }

    //Brute Solution
    //TC : O(2n)
    //SC : O(n)
    public static void moveZeroesB(int[] arr) {
        int n = arr.length ; 
        
        ArrayList<Integer> temp = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            if(arr[i]!=0){
                temp.add(arr[i]) ;
            }
           
        }

        for(int i=0;i<n ;i++){
            if(i<temp.size()){
                arr[i] = temp.get(i) ;
            }
            else{
                arr[i] = 0 ;
            }
        }
    }
}
