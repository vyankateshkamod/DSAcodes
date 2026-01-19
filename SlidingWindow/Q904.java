import java.util.*;
public class Q904 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,1,2,1,1,2,3,3,4}));
    }

    // optimal
    // tc : n
    // sc : 1
    public static int totalFruit(int[] fruits) {
        int n = fruits.length ;
        HashMap<Integer,Integer> Map = new HashMap<>();
        int l = 0, r = 0, maxF = 0;

        while(r < n){
            Map.put(fruits[r], Map.getOrDefault(fruits[r],0)+1) ;

            if(Map.size() > 2){
                Map.put(fruits[l], Map.get(fruits[l])-1);
                if(Map.get(fruits[l]) == 0){
                    Map.remove(fruits[l]);
                }
                l++;
            }

            if(Map.size() <= 2){
                maxF = Math.max(maxF, r-l+1);
            }
            

            r++;
        }

        return maxF ;
    }

    // better
    // tc : 2n
    // sc : 1
    public int totalFruit2(int[] fruits) {
        int n = fruits.length ;
        HashMap<Integer,Integer> Map = new HashMap<>();
        int l = 0, r = 0, maxF = 0;

        while(r < n){
            Map.put(fruits[r], Map.getOrDefault(fruits[r],0)+1) ;

            while(Map.size() > 2){
                Map.put(fruits[l], Map.get(fruits[l])-1);
                if(Map.get(fruits[l]) == 0){
                    Map.remove(fruits[l]);
                }
                l++;
            }

            maxF = Math.max(maxF, r-l+1);

            r++;
        }

        return maxF ;
    }

    // brute
    // tc : n2
    // sc : 1
    public static int totalFruit3(int[] fruits) {
        int n = fruits.length ;
        HashSet<Integer> set ;
        int maxF = 0;
        for(int i = 0 ; i < n ; i++){
            set = new HashSet<>() ;
            for(int j = i ; j < n ; j++){
                set.add(fruits[j]);
                if(set.size() <= 2){
                    int len = j - i + 1;
                    maxF = Math.max(maxF, len);
                } else{
                    break ;
                }
            }
        }
        return maxF ;
    }
}