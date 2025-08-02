import java.util.* ;

public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    // tc : n + n
    // sc : n + n
    public static String infixToPostfix(String s) {
        
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        Map<Character , Integer> map = new  HashMap<>() ;
        map.put('^',3);
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);
        
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            
            if(
                ch >= 'a' && ch <= 'z' ||
                ch >= 'A' && ch <= 'Z' ||
                ch >= '0' && ch <= '9' 
            ){
                ans.append(ch) ;
            }
            
            else if(ch == '('){
                stk.push('(') ;
            }
            
            else if(ch == ')'){
                while(!stk.isEmpty() && stk.peek() != '('){
                    ans = ans.append(stk.peek()) ;
                    stk.pop() ;
                }
                stk.pop() ;
            }
            
            else{
                while(!stk.isEmpty() && stk.peek() != '(' && map.get(ch) <= map.get(stk.peek())){
                    ans.append(stk.peek());
                    stk.pop() ;
                }
                stk.push(ch) ;
            }
        }
        
        while(!stk.isEmpty()){
            ans.append(stk.peek()) ;
            stk.pop() ;
        }
        
        return ans.toString() ;
    }
}