//917. Reverse Only Letters
class Q917{
    public static  void main(String[] args) {
     String str = "Test1ng-Leet=code-Q!" ;
     System.out.println(reverseOnlyLetters(str));   
    }
    public static  String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length() - 1;
        // 65 to 122
        // A to z
        int r = n;
        int l = 0;
        while (l < r) {
            if (isEnglish(sb.charAt(l))) {
                while (!(isEnglish(sb.charAt(r)))) {
                    r--;
                }
                char temp = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, temp);
                r--;
            }
            l++;
        }

        return sb.toString();
    }
    public static boolean isEnglish(char c){
        return (c >= 65 && c<= 90) || (c>= 97 && c <= 122) ;
    }
}