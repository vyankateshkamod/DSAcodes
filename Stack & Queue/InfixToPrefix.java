
import java.util.*;

public class InfixToPrefix {

    public static void main(String[] args) {
        System.out.println(infixToPrefix("a*b+c/d"));
    }

    // tc : n
    // sc : n
    public static String infixToPrefix(String s) {
        s = reverseAndSwap(s);
        StringBuilder ans = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z'
                    || ch >= 'A' && ch <= 'Z'
                    || ch >= '0' && ch <= '9') {
                ans.append(ch);
            } else if (ch == '(') {
                stk.push('(');
            } else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    ans.append(stk.peek());
                    stk.pop();
                }
                stk.pop();
            } else {
                while (!stk.isEmpty()
                        && map.containsKey(stk.peek())
                        && map.get(stk.peek()) > map.get(ch)) {
                    ans.append(stk.peek());
                    stk.pop();
                }
                stk.push(ch);
            }
        }

        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }

        String res = ans.toString();

        return reverseOnly(res);
    }

    public static String reverseOnly(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseAndSwap(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                str.append(')');
            } else if (ch == ')') {
                str.append('(');
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
