public class bubble {
    public static void main(String[] args) {
        int[]arr ={3,41,6,2,54,26} ;
        bubbleSort(arr);
        for(int item:arr){
            System.out.print(item + " ");
        }
    }
    public static void bubbleSort(int arr[]) {
        int n = arr.length ;
        for(int i = n - 1 ; i >= 1 ; i--){
            for(int j = 0 ; j <= i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                }
            }
        }
    }
}
