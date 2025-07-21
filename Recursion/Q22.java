import java.util.ArrayList ;
import java.util.List ;

public class Q22 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() ;
        list = generateParenthesis(3) ;
        for(String s : list){
            System.out.println(s);
        }
    }

    // optimal
    // tc : (2 ^ 2n)
    // sc : 2n recursion depth
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        int open = 0;
        int close = 0;
        solve(s, n, list, open, close);
        return list;
    }

    public static void solve(StringBuilder s, int n, List<String> list, int open, int close) {
        if (s.length() == 2 * n) {
            list.add(s.toString());
            return;
        }

        if (open < n) {
            s.append('(');
            solve(s, n, list, open+1, close);
            s.deleteCharAt(s.length() - 1);
        }

        if (close < open) {
            s.append(')');
            solve(s, n, list, open, close+1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    // brute
    // tc : (2 ^ 2n) + n
    // sc : 2n recursion depth
    public static  List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>() ;
        StringBuilder s = new StringBuilder() ;
        solve(s,n,list) ;
        return list ;
    }

    public static  void solve(StringBuilder s ,int n, List<String> list){
        if(s.length() == 2*n){
            if(isValid(s)){
                list.add(s.toString()) ;
            }
            return ;
        }
        s.append('(') ;
        solve(s,n,list) ;
        s.deleteCharAt(s.length()-1) ;

        s.append(')') ;
        solve(s,n,list) ;
        s.deleteCharAt(s.length()-1) ;
    }

    public static boolean isValid(StringBuilder s){
        int cnt = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                cnt++ ;
            }
            else if(s.charAt(i) == ')'){
                cnt-- ;
            }

            if(cnt < 0) return false ;
        }
        if(cnt == 0) return true ;
        return false ;
    }
}