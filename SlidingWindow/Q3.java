// both solutions are ok
import java.util.HashMap;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    // tc : n
    // sc : 1
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }

        while (r < n) {
            char ch = s.charAt(r);
            if (map[ch] != -1 && map[ch] >= l) {
                l = map[ch] + 1;
            } 
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);

            map[ch] = r;
            r++;
        }

        return maxLen;
    }

    // tc : n
    // sc : n
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {

            char ch = s.charAt(r);
            if (map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
            } 
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);

            map.put(ch, r);
            r++;
        }

        return maxLen;
    }
}