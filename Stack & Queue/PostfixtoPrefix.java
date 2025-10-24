import java.util.Stack ;
public class PostfixtoPrefix {
    public static void main(String[] args) {
        System.out.println(postToPre("ABC/-AK/L-*"));
    }

    // tc : n
    // sc : n
    static String postToPre(String post_exp) {
        int i = 0 ; 
        int n = post_exp.length() ;
        Stack<String> stk = new Stack<>() ;
        while(i < n){
            char ch = post_exp.charAt(i) ;
            // if operand
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch <= '0' && ch >= '9'){
                stk.push(String.valueOf(ch)) ;
            }
            // if operator
            else{
                String t1 = stk.pop() ;
                String t2 = stk.pop() ;
                String op = String.valueOf(ch) ;
                stk.push(op + t2 + t1) ;
            }
            i++ ;
        }
        return stk.peek() ;
    }
}