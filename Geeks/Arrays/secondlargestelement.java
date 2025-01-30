public class secondlargestelement{
    public static void main(String[] args){
        System.out.println(getSecondLargest(new int[]{45,32,12,67,21,54,98,212}));
    }
    public static int getSecondLargest(int[] arr) {
        // Code Here
        int largest = arr[0] ;
        int slargest = -1;
        
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i] > largest){
                slargest = largest ;
                largest = arr[i] ;
            }
            if(arr[i] < largest && arr[i] > slargest){
                slargest = arr[i] ;
            }
        }
        
       
        return slargest ;
        
    }
}