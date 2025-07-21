import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

public class Q17 {
    public static void main(String[] args) {
        for(String str : letterCombinations("23")){
            System.out.println(str);
        }
    }

    // tc : 4^n
    // sc : n(recursion)+ 4^n * n(ans) + n(StringBuilder) 
    public static  List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>() ;
        if(digits.length() == 0) return ans ;
        Map<Character,String> map = new HashMap<>() ;
        map.put('2',"abc") ;
        map.put('3',"def") ;
        map.put('4',"ghi") ;
        map.put('5',"jkl") ;
        map.put('6',"mno") ;
        map.put('7',"pqrs") ;
        map.put('8',"tuv") ;
        map.put('9',"wxyz") ;

        StringBuilder comb = new StringBuilder() ;
        solve(0,digits,comb,ans,map) ;
        return ans ;
    }

    public static void solve(int idx , String digits , StringBuilder comb , List<String> ans , Map<Character , String> map){
        if(idx == digits.length()){
            ans.add(comb.toString()) ;
            return ;
        }

        char digit = digits.charAt(idx) ;
        String str = map.get(digit) ;
        for(int i = 0 ; i < str.length() ; i++){
            // do
            comb.append(str.charAt(i)) ;
            // explore
            solve(idx + 1 , digits , comb , ans , map) ;
            // undo
            comb.deleteCharAt(comb.length()-1) ;
        }
    }
}