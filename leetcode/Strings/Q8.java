public class Q8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("  -043"));
    }

    // tc : n
    // sc : 1
    public static  int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        long ans = 0;
        boolean neg = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (i == 0) {
                if (c == '-') {
                    neg = true;
                    continue;
                } else if (c == '+') {
                    continue;
                }
            }

            if (c >= '0' && c <= '9') {
                int digit = c - '0';
                ans = ans * 10 + digit;

                if (neg) {
                    long check = -ans;
                    if (check < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (ans > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }

            else {
                break;
            }
        }

        if (neg) {
            ans = -ans;
        }

        return (int) ans;
    }
}
