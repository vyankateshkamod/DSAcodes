public class Q1752{
    public static void main(String[] args) {
        System.err.println(check(new int[]{3,4,5,1,2}));
    }
    public static boolean check(int[] arr) {
        int n =  arr.length ;
        int cnt = 0 ;

        for(int i = 1 ; i<n ;i++){
            if(arr[i] < arr[i-1]){
                cnt ++ ; 
            }
        }

        if(arr[n-1] > arr[0]){
            cnt++ ;
        }
        
        if(cnt>1){
            return false ;
        }else{
            return true ;
        }
    }
}