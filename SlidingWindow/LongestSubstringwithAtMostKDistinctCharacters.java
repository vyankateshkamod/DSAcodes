
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(kDistinctChars(2, "aaabbccd"));
    }

    // optimal
	// tc : n
	// sc : k
    public static int kDistinctChars(int k, String str) {
		int n = str.length() ;
		HashMap<Character,Integer> map = new HashMap<>();
		int maxLen = 0 , l = 0 , r = 0;

		while(r < n){
			
			char ch = str.charAt(r);
			map.put(ch, map.getOrDefault(ch,0)+1);
			
			
			if(map.size() > k){
				char lch = str.charAt(l);
				map.put(lch, map.get(lch)-1);
				if(map.get(lch) == 0){
					map.remove(lch) ;
				}
				l++;
			}
			
			if(map.size() <= k){
				maxLen = Math.max(maxLen,r-l+1);
			}
			
			r++;
		}
		return maxLen ;
	}

    // optimal
	// tc : 2n
	// sc : k
	public static int kDistinctChars2(int k, String str) {
		int n = str.length() ;
		HashMap<Character,Integer> map = new HashMap<>();
		int maxLen = 0 , l = 0 , r = 0;

		while(r < n){
			
			char ch = str.charAt(r);
			map.put(ch, map.getOrDefault(ch,0)+1);
			
			
			while(map.size() > k){
				char lch = str.charAt(l);
				map.put(lch, map.get(lch)-1);
				if(map.get(lch) == 0){
					map.remove(lch) ;
				}
				l++;
			}

			maxLen = Math.max(maxLen,r-l+1);
			
			r++;
		}
		return maxLen ;
	}

    // brute
	// tc : n2
	// sc : k
	public static int kDistinctChars3(int k, String str) {
		int n = str.length() ;
		HashSet<Character> set;
		int maxLen = 0 ;
		for(int i = 0 ; i < n ; i++){
			set = new HashSet<>();
			int uniques = 0 ;
			for(int j = i ; j < n ; j++){
				char ch = str.charAt(j);
				if(!set.contains(ch)){
					set.add(ch);
					uniques++;
				}		
				if(uniques > k){
					break ;
				}
				maxLen = Math.max(maxLen,j-i+1);
			}
		}
		return maxLen ;
	}
}