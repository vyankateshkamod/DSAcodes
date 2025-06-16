
public class AtoiBasic {

    public static void main(String[] args) {
        System.out.print(myAtoi("1234"));
    }

    public static int myAtoi(String s) {
        return helper(s, 0, 0);
    }

    public static int helper(String s, int index, int result) {
        if (index == s.length()) {
            return result;
        }
        int digit = s.charAt(index) - '0';
        result = result * 10 + digit;
        return helper(s, index + 1, result);
    }
}
