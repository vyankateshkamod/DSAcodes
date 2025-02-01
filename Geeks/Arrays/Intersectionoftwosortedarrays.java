import java.util.ArrayList;

public class Intersectionoftwosortedarrays {
    public static void main(String[] args){
        int a[] = {6,7,8,9,9} ;
        int b[] = {3,4,5,6,7,8} ;
        ArrayList<Integer> arr = new ArrayList<>(intersection(a, b)) ;
        System.out.println(arr);
    }
    // TC : O(n1 + n2)
    // SC : O(1)
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        ArrayList<Integer> list = new ArrayList<>() ;
        int i = 0 ;
        int j = 0 ;
        int n1 = arr1.length ;
        int n2 = arr2.length ;
        while(i!=n1 && j!=n2){
            if(arr1[i]==arr2[j]){
                if(list.size() == 0  || arr1[i] != list.get(list.size()-1)){
                    list.add(arr1[i]) ;
                }
                i++ ;
                j++ ;
                
            }
            else{
                if(arr1[i] > arr2[j]){
                    j++ ;
                }
                else{
                    i++ ;
                }
            }
        }
        
        return list ;
    }
}
