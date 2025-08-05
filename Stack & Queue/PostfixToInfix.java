import java.util.Stack ;
public class PostfixToInfix {
    public static void main(String[] args) {
        System.out.println(postToInfix("ab*c+"));
    }

    // tc : n
    // sc : n
    static String postToInfix(String exp) {
        
        Stack<String> stk = new Stack<>() ;
        
        for(int i = 0 ; i < exp.length() ; i++){
            
            char ch = exp.charAt(i) ;
            
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9'){
                
                stk.push(String.valueOf(ch));
            }
            else{
                
                String t1 = stk.pop() ; // top
                String t2 = stk.pop() ; // prev to top
                String t = "(" + t2 + ch + t1 + ")" ;
                
                stk.push(t) ;
            }
        }
        
        return stk.peek() ;
    }
}