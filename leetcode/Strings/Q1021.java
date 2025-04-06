import java.util.Stack;

public class Q1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    // optimal
    // tc : n
    // sc : 1
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (cnt != 0) {
                    ans.append('(');
                }
                cnt++;
            } else {
                cnt--;
                if (cnt != 0) {
                    ans.append(')');
                }
            }
        }
        String finalAns = ans.toString();
        return finalAns;
    }

    // Better
    // tc : n
    // sc : n
    public String removeOuterParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!stack.isEmpty()) {
                    ans.append('(');
                }
                stack.push('(');
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans.append(')');
                }
            }
        }
        String finalAns = ans.toString();
        return finalAns;
    }
}