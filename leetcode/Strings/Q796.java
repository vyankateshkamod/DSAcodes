public class Q796 {
    public static void main(String[] args) {
        System.out.println(rotateString("hello", "llohe")); 
    } 
    // optimal
    // tc : n
    // sc : 2n
    // if goal will present in s + s  return true 
    // if not return false 
    public static  boolean rotateString(String s, String goal) {
        int n = s.length() ;
        int m = goal.length() ;
        if(n != m) return false ;
        String str = s + s ;
        if(str.contains(goal)) return true ;
        return false ;
    }

    // brute
    // tc : n2
    public static  boolean rotateString2(String s, String goal) {
        int n = s.length() ;
        if(s.equals(goal)) return true ;
        for(int i = 0 ; i < n ; i++){
            s = s.substring(1) + s.charAt(0) ;
            if(s.equals(goal)) return true ;
        }
        return false ;
    }
}
