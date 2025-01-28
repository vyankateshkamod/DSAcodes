// TC : worst/avg case = O(n sq)    best case = O(n)  where no swaps 

import java.util.Arrays;

public class insertionrecursive {

    static void insertionSortRecursive(int arr[], int n) {
            //  0   1   2  3  4
            // 12, 11, 13, 5, 6 
        
        if(n>1){
            insertionSortRecursive(arr, n-1);

        }

        int j = n-1 ;
        while (j > 0 &&  arr[j - 1] > arr[j]) {

            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;

        }

    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };

        insertionSortRecursive(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
