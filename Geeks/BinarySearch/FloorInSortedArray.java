public class FloorInSortedArray{
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 12, 14, 19};
        int k = 9;
        int floorIndex = findFloor(arr, k);
        System.out.println("Floor index of " + k + " is: " + floorIndex);
    }
    static int findFloor(int[] arr, int k) {
        int n = arr.length ;
        int low = 0 ;
        int high = n-1 ;
        int max_idx = -1 ;
        
        while(low <= high){
            
            int mid = low + (high-low) / 2 ;  // avoids overflow 
            
            if(arr[mid] == k) return mid ;
            
            else if(arr[mid] < k){
                max_idx = mid ;
                low = mid + 1 ;
            } 
            
            else if(arr[mid] > k) high = mid - 1 ;
        }
        
        return max_idx ;
    }
}