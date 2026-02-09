public class CheckIfAnArrayRepresentsAMinHeap {
    public static void main(String[] args) {
        long[] arr = {2, 5, 4, 10, 20, 9, 8};
        System.out.println(countSub(arr, 7));
    }

    public static boolean countSub(long arr[], long n) {
        
        for(int i = 1 ; i < n ; i++){
            int p = parent(i);
            if(arr[p] > arr[i]){ // just change the sign for maxHeap
                return false;
            }
        }
        
        return true;
    }
    
    public static int parent(int index){
        return (index-1)/2 ;
    }
}