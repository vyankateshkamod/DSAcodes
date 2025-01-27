public class quicksort {
    public static void main(String[] args) {
        int[]arr ={2, 1, 6, 10, 4, 1, 3, 9, 7} ;
        quickSort(arr,0,8);
        for(int item:arr){
            System.out.print(item + " ");
        }
    }
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low >= high){
            return ;
        }
        int Pi = partition(arr,low,high) ;
        quickSort(arr,low,Pi-1) ;
        quickSort(arr,Pi+1,high) ;
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int pivot = arr[high] ;
        int Pi = low ;
        
        for(int i = low ; i < high ; i++){
            if(arr[i] <= pivot){
                int temp = arr[i] ;
                arr[i] = arr[Pi] ;
                arr[Pi] = temp ;
                Pi++ ;
            }
        }
        
        int temp = arr[Pi] ;
        arr[Pi] = arr[high] ;
        arr[high] = temp ;
        
        
        return Pi ;
    }
}
