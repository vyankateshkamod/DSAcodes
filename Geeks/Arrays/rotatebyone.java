public class rotatebyone {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7} ;
        rotate(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void rotate(int[] arr) {
        // code here
        int n = arr.length ;
        int temp = arr[n-1] ;
        for(int i = n-2 ;i >= 0 ;i--){
            arr[i+1] = arr[i] ;
        }
        arr[0] = temp ;
    }
}
