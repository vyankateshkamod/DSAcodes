
import java.util.*;

public class Q139 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>() ;
        wordDict.add("leet") ;
        wordDict.add("code") ;
        System.out.println(wordBreak("leetcode", wordDict));
    }

    //  n = s.length() and m = wordDict.size()
    // TC = O(2ⁿ × n × m)
    // SC = n(recursion)
    public static boolean wordBreak(String s, List<String> wordDict) {
        return solve(0, s, wordDict);
    }

    public static boolean solve(int idx, String str, List<String> wordDict) {
        if (idx == str.length()) {
            return true;
        }

        for (int i = idx; i < str.length(); i++) {
            if (isPresent(idx, i, str, wordDict) && solve(i + 1, str, wordDict)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPresent(int start, int end, String str, List<String> wordDict) {

        String temp = str.substring(start, end + 1);

        if (wordDict.contains(temp)) {
            return true;
        }
        return false;
    }
}
