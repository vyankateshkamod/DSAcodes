import java.util.Arrays;
import java.util.HashMap;

public class Q205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic2("paper", "title"));
    }
    // optimal
    // tc : n
    // sc : 1
    public static boolean isIsomorphic(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        for (int i = 0; i < m; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map1[a] == -1 && map2[b] == -1) {
                map1[a] = b;
                map2[b] = a;
            } else if (map1[a] != b || map2[b] != a) {
                return false;
            }
        }
        return true;
    }

    // better
    // tc : n * map_keys = n2
    // sc : n
    public static boolean isIsomorphic2(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if ((map.containsKey(a) && map.get(a) != b) || (!map.containsKey(a) && map.containsValue(b))) {
                return false;
            }
            map.put(a, b);
        }
        return true;
    }
}
