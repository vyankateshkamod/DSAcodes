import java.util.HashMap;

public class Q1358 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    // optimal
    // tc : 2n
    // sc : 1
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0 , l = 0 , r = 0 ;
        map.put('a',0) ;
        map.put('b',0) ;
        map.put('c',0) ;

        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get('a') >= 1 && map.get('b') >= 1 && map.get('c') >= 1) {
                cnt = cnt + (n - r);
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }

            r++ ;
        }
        
        return cnt;
    }

    // brute
    // tc : n2
    // sc : 1
    public static int numberOfSubstrings2(String s) {
        int n = s.length();
        HashMap<Character,Integer> map ;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            map = new HashMap<>();
            for(int j = i ; j < n ; j++){
                char ch = s.charAt(j) ;
                map.put(ch, map.getOrDefault(ch,0)+1);
                if(map.get('a') != null && map.get('b') != null && map.get('c') != null){
                    cnt++;
                }
            }
        }
        return cnt ;
    }
}