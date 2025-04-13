public class Q1903{
    public static void main(String[] args) {
        System.out.println(largestOddNumber("3542786"));
    }
    // tc : n
    public static String largestOddNumber(String s) {
        int n = s.length() ;
        for(int i = n-1 ; i >= 0 ; i--){
            if((s.charAt(i) - '0') % 2 == 1){
                return s.substring(0,i+1) ;
            }
        }
        return "" ;
    }
}