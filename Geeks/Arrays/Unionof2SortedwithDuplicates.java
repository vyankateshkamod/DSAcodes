import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Unionof2SortedwithDuplicates {
    public static void main(String[] args) {
        int a[] = {6,7,8,9,9} ;
        int b[] = {3,4,5,6,7,8} ;
        ArrayList<Integer> arr = new ArrayList<>(findUnion2(a, b)) ;
        System.out.println(arr);
    }

    //Brute Solution
    //TC : O((n + m) log (n + m))
    //SC : O(n + m)

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        
        Set<Integer> set = new HashSet<>() ;
        for(int i = 0 ;i<a.length ;i++){
            set.add(a[i]) ;
        }
        for(int i=0 ;i<b.length ;i++){
            set.add(b[i]) ;
        }
        
        ArrayList<Integer> union = new ArrayList<>(set) ;
        Collections.sort(union) ;
        return union ;
    }


    //Optimal solution
    //TC : O(n1 + n2)
    //SC : O(n1 + n2)
    public static ArrayList<Integer> findUnion2(int a[], int b[]) {
        
        ArrayList<Integer> list = new ArrayList<>() ;
        int n1 = a.length ;
        int n2 = b.length ;
        int i  = 0 ;
        int j = 0 ;
        
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                
                if(list.size()==0 || list.get(list.size()-1)!=a[i]){
                    list.add(a[i]) ;
                }
                i++ ;
            }
            else{
                if(list.size()==0 || list.get(list.size()-1)!=b[j]){
                    list.add(b[j]) ;
                }
                j++ ;
            }
        }
        while(i<n1){
            if(list.size()==0 || list.get(list.size()-1)!=a[i]){
                list.add(a[i]) ;
            }
            i++ ;
        }
        while(j<n2){
            if(list.size()==0 || list.get(list.size()-1)!=b[j]){
                list.add(b[j]) ;
            }
            j++ ;
        }
        
        return list ;
    }
}
