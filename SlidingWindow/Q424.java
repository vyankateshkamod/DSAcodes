import java.util.*;

public class Q424 {
    public static void main(String[] args) {
        String s = "AAABBCCD";
        System.out.println(characterReplacement(s, 2));
    }

    // optimal
    // tc : n
    // sc : 26
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0, r = 0, l = 0;
        int maxF = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            maxF = Math.max(maxF, map.get(s.charAt(r)));

            if((r-l+1)-maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            if ((r-l+1)-maxF <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }

    // better
    // tc : 2n * 26
    // sc : 26
    public static int characterReplacement2(String s, int k) {
        int n = s.length();
        int maxLen = 0, r = 0, l = 0;
        int maxF = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            maxF = Math.max(maxF, map.get(s.charAt(r)));

            while ((r-l+1)-maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                maxF = 0 ;
                for(Character ch : map.keySet()){
                    maxF = Math.max(maxF, map.get(ch));
                }
                l++;
            }

            if ((r-l+1)-maxF <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }

    // brute
    // tc : n2
    // sc : 26
    public static int characterReplacement3(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        
        for(int i = 0 ; i < n ; i++){
            HashMap<Character,Integer> map = new HashMap<>();
            int maxF = 0;
            for(int j = i ; j < n ; j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);

                maxF = Math.max(maxF, map.get(s.charAt(j)));

                int changes = (j-i+1) - maxF ;

                if(changes <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                } else{
                    break;
                }
            }
        }

        return maxLen ;
    }
}