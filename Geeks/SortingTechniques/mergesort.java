// TC : O(n logn)
// SC : O(n)


public class mergesort {
    public static void main(String[] args) {
        int[]arr ={3,41,6,2,54,26} ;
        mergeSort(arr,0,5);
        for(int item:arr){
            System.out.print(item + " ");
        }
    }
    public static void mergeSort(int arr[], int l, int r) {
        // code here
        int mid ;
        
        if(l>=r){
            return ;
        }
        mid = l+ (r-l)/2 ;
        mergeSort(arr,l,mid) ;
        mergeSort(arr,mid+1,r) ;
        merge(arr,l , mid, r) ;
        
    }
    
    public static void merge(int[]arr , int l, int mid , int r){
        int i , j , k ;
        i = l ;
        j = mid+1 ;
        int[]B = new int[r+1] ;
        k = l ;
        
        while(i<=mid && j<=r){
            if(arr[i] < arr[j]){
                B[k] = arr[i] ;
                i++ ; 
                k++ ;
            }
            else{
                B[k] = arr[j] ;
                j++ ;
                k++ ;
            }
        }
        while(i<=mid){
            B[k] = arr[i] ;
            i++ ;
            k++ ;
        }
        while(j<=r){
            B[k] = arr[j] ;
            j++ ;
            k++ ;
        }
        // for(i = l ; i<=r ; i++){
        //     arr[i] = B[i] ;
        // }
        System.arraycopy(B , l , arr , l , r-l+1) ;
    }
}
