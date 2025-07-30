import java.util.Stack;
public class Q20 {
    public static void main(String[] args) {
        System.out.println(isValid("((()))"));
    }
    // tc : n
    // sc : n
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch =='[' || ch == '{'){
                stk.push(ch);
            }
            else{
                if(stk.isEmpty()) return false;
                char opening = stk.pop();
                if(opening == '(' && ch != ')'){
                    return false;
                }
                else if(opening == '[' && ch != ']'){
                    return false;
                }
                else if(opening == '{' && ch != '}'){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}