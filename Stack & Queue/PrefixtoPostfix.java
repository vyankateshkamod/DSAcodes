import java.util.* ;
public class PrefixtoPostfix {
    public static void main(String[] args) {
        System.out.println(preToPost("*-A/BC-/AKL"));
    }

    static String preToPost(String pre_exp) {
        int i = pre_exp.length() - 1 ;
        
        Stack<String> stk = new Stack<>() ;
        while(i >= 0){
            char ch = pre_exp.charAt(i) ;
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9'){
                stk.push(String.valueOf(ch)) ;
            }
            else{
                String t1 = stk.pop() ;
                String t2 = stk.pop() ;
                String op = String.valueOf(ch) ;
                stk.push(t1 + t2 + op) ;
            }
            i-- ;
        }
        
        return stk.peek() ;
    }
}