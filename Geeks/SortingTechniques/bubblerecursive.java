import java.util.Arrays ;

public class bubblerecursive {
    
	// A function to implement bubble sort 
	static void bubbleSort(int arr[], int n) 
	{   
        n-- ;
		for(int i = 0 ; i<n ;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i] ;
                arr[i] = arr[i+1] ;
                arr[i+1] = temp ;
            }
        }
        if(n>0){
            bubbleSort(arr, n);
        }
	} 
	
	// Driver Method 
	public static void main(String[] args) 
	{ 
		int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
	
		bubbleSort(arr, arr.length); 
		
		System.out.print("Sorted array : "); 
		System.out.println(Arrays.toString(arr)); 
	} 
} 
