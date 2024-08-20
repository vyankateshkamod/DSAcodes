// Custom Sort String

import java.util.Set ;
import java.util.HashSet ;

public class Q791 {
    public static void main(String[] args) {
        System.out.print(customSortString("cba","abcd")) ;
    }
    public static String customSortString(String order, String s) {
        Set<Character> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        int[]ca = new int[26] ;

        for(char i : order.toCharArray()){
            set.add(i) ;
        }
        for(char i : s.toCharArray()){
            if(!set.contains(i)){
                sb.append(i) ;
            }
            else{
                ca[i-'a']++ ;
            }
        }
        for(char c : order.toCharArray()){
            int i = ca[c - 'a'] ;
            while(i-- > 0){
                sb.append(c) ;
            }
        }
        return sb.toString() ;
    }
}
