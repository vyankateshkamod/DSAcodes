import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    // optimal
    // bucket sort
    // tc : 3n
    // sc : 2n
    public static  String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<Character>[] arr = new ArrayList[n + 1];

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // adding characters from map to the arr in which index position is the count of frequency 
        for(Character c : map.keySet()){
            if(arr[map.get(c)] == null){
                arr[map.get(c)] = new ArrayList() ;
            }
            arr[map.get(c)].add(c) ;
        }

        // traversing from last to add most frequent character first to the sb 
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(arr[i] != null){
                for(Character c : arr[i]){
                    for(int j = 0 ; j < i ; j++){
                        sb.append(c) ;
                    }
                }
            }
        }

        return sb.toString();
    }

    // brute
    // tc : n2
    // sc : n
    public static  String frequencySort2(String s) {
        int n = s.length() ;
        HashMap<Character,Integer> map = new HashMap<>() ;
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < n ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1) ;
        }
        for(int i = n ; i > 0 ; i--){
            for(char key : map.keySet()){
                if(map.get(key) == i){
                    for(int j = 0 ; j < i ; j++){
                        sb.append(key) ;
                    }
                }
            }
        }
        return sb.toString() ;
    }
}
