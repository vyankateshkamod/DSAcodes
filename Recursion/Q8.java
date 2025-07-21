
public class Q8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("1234"));
        System.out.println(myAtoi("12bv34"));
        System.out.println(myAtoi("12-34"));
        System.out.println(myAtoi("-1234"));
        System.out.println(myAtoi("-123439849344"));
        System.out.println(myAtoi("  9344"));
        System.out.println(myAtoi("  "));
        System.out.println(myAtoi(""));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        boolean isNegative = false;
        if (s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        return helper(s, i, 0, isNegative);
    }

    public static int helper(String s, int index, int result, boolean isNegative) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return isNegative ? -result : result;
        }

        int digit = s.charAt(index) - '0';

        long check = (long) result * 10 + digit;
        if (check > Integer.MAX_VALUE) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        result = result * 10 + digit;

        return helper(s, index + 1, result, isNegative);
    }
}
