import java.util.Arrays;
import java.util.HashMap;

public class Q242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    
    // optimal
    // tc : n 
    // sc : 1
    // a to z => 97 to 122
    public static  boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false ;

        int[] arr = new int[26] ;
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i)-97]++ ;
        }
        for(int i = 0 ; i < t.length() ; i++){
            arr[t.charAt(i)-97]-- ;
            if(arr[t.charAt(i)-97] < 0)  return false ;
        }
        return true ;
    }

    // optimal
    // tc : 2n 
    // sc : 1  // because 26 characters only 
    public static  boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false ;

        HashMap<Character,Integer> map = new HashMap<>() ;

        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1) ;
        }

        for(int i = 0 ; i < t.length() ; i++){
            if(!map.containsKey(t.charAt(i))) return false ;
            map.put(t.charAt(i),map.get(t.charAt(i))-1) ;
            if(map.get(t.charAt(i)) < 0) return false ;
        }
        return true ;
    }

    // brute
    // tc : n log n
    // sc : n
    public static boolean isAnagram3(String s, String t) {
        char[] a = s.toCharArray() ;
        char[] b = t.toCharArray() ;
        Arrays.sort(a) ;
        Arrays.sort(b) ;
        return Arrays.equals(a,b) ;
    }
}
