import java.util.Stack ;
public class PrefixToInfix {
    public static void main(String[] args) {
        System.out.println(preToInfix("*-A/BC-/AKL"));
    }

    // tc : n
    // sc : n
    static String preToInfix(String s) {
        Stack<String> stk = new Stack<>() ;
        
        for(int i = s.length()-1 ; i >= 0 ; i--){
            
            char ch = s.charAt(i) ;
            
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9'){
                
                stk.push(String.valueOf(ch)) ;
            }
            else{
                
                String t1 = stk.pop() ;
                String t2 = stk.pop() ;
                String t = "(" + t1 + ch + t2 + ")" ;
                stk.push(t) ;
            }
        }
        
        return stk.peek() ;
    }
}