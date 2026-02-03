
import java.util.HashMap;

public class Q76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    // optimal
    // tc : m + 2n
    // sc : m
    public static String minWindow(String s, String t) {
        int n = s.length() ;
        int m = t.length() ;
        HashMap<Character, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int cnt = 0 ;
        int start = -1;
        int end = -1;

        for(int j = 0 ; j < m ; j++){
            char ch = t.charAt(j) ;
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int l = 0 , r = 0 ;
        while(r < n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0) cnt++;
                map.put(ch, map.get(ch)-1);
            }

            while(cnt == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    start = l;
                    end = r;
                }
    
                char lch = s.charAt(l);
                if(map.containsKey(lch)){
                    map.put(lch, map.get(lch)+1);
                    if(map.get(lch) > 0) cnt--;
                }

                l++;
            }

            r++;
        }

        return start == -1 ? "" :  s.substring(start, end+1);
    }


    // brute
    // tc : n2
    // sc : 256
    public static String minWindow2(String s, String t) {
        int n = s.length() ;
        int m = t.length() ;
        StringBuilder str ;
        HashMap<Character, Integer> map ;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        
        for(int i = 0 ; i < n ; i++){
            map = new HashMap<>();
            int cnt = 0 ;

            for(int j = 0 ; j < m ; j++){
                char ch = t.charAt(j) ;
                map.put(ch, map.getOrDefault(ch,0)+1);
            }

            for(int j = i ; j < n ; j++){
                char ch = s.charAt(j);
                if(map.containsKey(ch)){
                    if(map.get(ch) > 0) cnt++;
                    map.put(ch, map.get(ch)-1);
                }
                if(cnt == m){
                    if(j-i+1 < minLen){
                        minLen = j-i+1 ;
                        start = i ;
                        end = j ;
                    }
                    break ;
                }
            }
        }

        if(start == -1) return "";
        return s.substring(start, end+1);
    }
}