import java.util.HashMap;

public class Q1781{
    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }
    // optimal 
    // tc : n2
    // sc : 1
    public static int beautySum(String s) {
        int n = s.length();
        int beuty_cnt = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            for (int j = i; j < n; j++) {
                arr[s.charAt(j) - 'a']++;
                beuty_cnt += getMaxMin(arr);
            }
        }
        return beuty_cnt;
    }

    public static int getMaxMin(int[]arr){
        int min_cnt = Integer.MAX_VALUE;
        int max_cnt = 0;
        for (int k = 0; k < 26; k++) {
        if (arr[k] > 0) {
                min_cnt = Math.min(min_cnt, arr[k]);
                max_cnt = Math.max(max_cnt, arr[k]);
            }
        }
        return max_cnt - min_cnt ;
    }

    // brute
    // tc : n3
    // sc : 1
    public static int beautySum2(String s) {
        int n = s.length() ;
        int substr_beuty_cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                String str = s.substring(i,j+1) ;
                substr_beuty_cnt += countbeuty(str) ;
            }
        }
        return substr_beuty_cnt ;
    }

    public static int countbeuty(String s){
        HashMap <Character,Integer> map = new HashMap<>() ;
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1) ;
        }
        int max = 0 ;
        int min = Integer.MAX_VALUE ;
        for(char c : map.keySet()){
            if(map.get(c) > max){
                max = map.get(c) ;
            }
            if(map.get(c) < min){
                min = map.get(c) ;
            }
        }
        
        return max - min ;
    }
}