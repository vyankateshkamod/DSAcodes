import java.util.* ;
public class Q131 {
    public static void main(String[] args) {
        for(List<String> str : partition("aab")){
            System.out.println(str);
        }
    }

    // tc : 2^n * n
    // sc : O(n)    // recursive stack + current list O(2^n * n) // final result list

    public static  List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>() ;
        List<String> curr = new ArrayList<>() ;
        StringBuilder str = new StringBuilder(s) ;
        solve(0 , str , curr , ans) ;
        return ans ;
    }

    public static  void solve(int idx , StringBuilder str , List<String> curr , List<List<String>> ans){
        if(idx == str.length()){
            ans.add(new ArrayList(curr)) ;
            return ;
        }

        for(int i = idx ; i < str.length() ; i++){
            if(palindrome(str , idx , i)){
                curr.add(str.substring(idx , i+1)) ;
                solve(i+1 , str , curr , ans) ;
                curr.remove(curr.size()-1) ;
            }
        }
    }

    public static  boolean palindrome(StringBuilder str , int l , int r){
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false ;
            }
            l++ ;
            r-- ;
        }
        return true ;
    }
}