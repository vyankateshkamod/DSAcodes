public class insertion {
    public static void main(String[] args) {
        int[]arr ={3,41,6,2,54,26} ;
        insertionSort(arr);
        for(int item:arr){
            System.out.print(item + " ");
        }
    }
    public static void insertionSort(int arr[]) {
        int n = arr.length ;
    
        for(int i = 1 ; i < n ; i++){
            int key = arr[i] ;
            int j = i - 1 ;
            while(j>=0  && key < arr[j] ){
                arr[j+1] = arr[j] ;
                j-- ;
            }
            arr[j+1] = key ;
        }
    }
}
