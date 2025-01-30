public class Q189 {
    
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7} ;
        rotate(arr,3);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    // Optimal Solution
    // TC : O(2n)
    // SC : O(1)
    public static void rotate(int[] arr, int key) {
        int n = arr.length ;
        key = key % n ;

        reverse(arr,0,n-1) ;

        reverse(arr,0,key-1) ;
        
        reverse(arr,key,n-1) ;

    }
    public static  void reverse(int[]arr,int start , int end){
        while(start<end){
            int temp = arr[start] ;
            arr[start] = arr[end] ;
            arr[end] = temp ;
            start++ ;
            end-- ;
        }
    }
    //Brute Solution
    //TC : O(n)
    //SC : O(n)
    // public static void rotate(int[] arr, int key) {
    //     int n = arr.length ;
    //     int temp[] = new int[key] ;
    //     key = key % n ;

    //     for(int i = 0 ;i<key ;i++){
    //         temp[i] = arr[n-key+i] ;
    //     }
        
    //     for(int i = n - key -1 ; i>=0 ;i--){
    //         arr[i+key] = arr[i] ;
    //     }
        
    //     for(int i = 0 ;i<key ;i++){
    //         arr[i] = temp[i] ;
    //     }
    // }
}
