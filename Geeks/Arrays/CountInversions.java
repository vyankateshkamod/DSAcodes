import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = {5, 3, 2, 4, 1}; // Example array
        int result = inversionCount(arr);
        
        System.out.println("Number of inversions: " + result);
    }

    // Optimal
    // tc : n logn
    // sc : n
    static int inversionCount(int arr[]) {
        int n = arr.length ;
        return mergeSort(arr,0,n-1) ;
    }
    
    public static int mergeSort(int arr[], int l, int r) {
        int cnt = 0 ;
        int mid ;
        
        if(l>=r){
            return cnt;
        }
        mid = l+ (r-l)/2 ;
        cnt += mergeSort(arr,l,mid) ;
        cnt += mergeSort(arr,mid+1,r) ;
        cnt += merge(arr,l , mid, r) ;
        return cnt  ;
        
    }
    
    public static int merge(int[]arr , int low, int mid , int high){
       
        
        int left = low ;
        int right = mid + 1 ;
        
        ArrayList<Integer> list = new ArrayList<>() ;
        
        int cnt = 0 ;
        
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left] );
                left++ ; 
            }
            else{
                list.add(arr[right]) ;
                right++ ;
                cnt += (mid - left + 1) ;
            }
        }
        
        while(left <= mid){
            list.add(arr[left]) ;
            left++ ;
        }
        
        while(right <= high){
            list.add(arr[right]) ;
            right++ ;
        }
        
        
        for(int i = low ; i <= high ; i++){
            arr[i] = list.get(i-low) ;
        }
        
        
        return cnt ;
    }

    //brute
    // tc : n2
    // sc : 1
    static int inversionCount2(int arr[]) {
        int n = arr.length ;
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(arr[i] > arr[j]){
                    cnt++ ;
                }
            }
        }
        return cnt ;
    }
}


