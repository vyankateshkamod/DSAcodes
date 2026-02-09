import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4} ;
        convertMinToMaxHeap(4, arr);
        System.out.println(Arrays.toString(arr));
    }

    // tc : n 
    static void convertMinToMaxHeap(int N, int arr[]) {
        
        for(int i = N/2 - 1 ; i >= 0 ; i--){
            downheap(arr, N, i);
        }
        
    }
    
    static void downheap(int[] arr, int n, int index){
        int max = index ;
        int left = index * 2 + 1 ;
        int right = index * 2 + 2 ;
        
        if(left < n && arr[left] > arr[max]){
            max = left ;
        }
        
        if(right < n && arr[right] > arr[max]){
            max = right ;
        }
        
        if(max != index){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp ;
            
            downheap(arr, n, max);
        }
    }
}