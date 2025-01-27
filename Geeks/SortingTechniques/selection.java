public class selection{
    public static void main(String[] args) {
        int[]arr ={3,41,6,2,54,26} ;
        selectionSort(arr);
        for(int item:arr){
            System.out.print(item + " ");
        }
    }
    static void selectionSort(int[] arr) {
        
        for(int i = 0 ; i<arr.length-1 ; i++){
            int min_idx = i;
            
            for(int j = i+1 ; j<arr.length;j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j ;
                }
            }
            
            //swap
            int temp = arr[i] ;
            arr[i] = arr[min_idx] ;
            arr[min_idx] = temp ;
            
        }
    }
}