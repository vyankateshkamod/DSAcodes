// TC : worst/avg case = O(n sq)    best case = O(n)  where no swaps 


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
    
        for (int i = 0; i < n; i++) {       

            int j = i;
            while(j>0 && arr[j-1]>arr[j]){

                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j-- ;
            
            }
            
        }
    }
}
