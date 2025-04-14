public class Q1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    // tc : n
    public static int maxDepth(String s) {
        int n = s.length();
        int cnt = 0;
        int max_val = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                max_val = Math.max(max_val, cnt);
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        return max_val;
    }
}
