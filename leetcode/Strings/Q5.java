public class Q5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    // tc : n2 * n => n3
    public static  String longestPalindrome(String s) {
        int n = s.length() ;
        String str = "" ;
        int maxlen = 0 ;
        int start_idx = 0 ;
        int end_idx = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(checkPalindrome(s,i,j)){
                    if(maxlen < (j-i+1)){
                        maxlen = (j-i+1) ;
                        start_idx = i ;
                        end_idx = j ;
                    }
                }
            }
        }
        s = s.substring(start_idx,end_idx+1) ;
        return s ;
    }

    // interative
    // public static boolean checkPalindrome(String s , int i , int j){
    //     while(i <= j){
    //         if(s.charAt(i) == s.charAt(j)){
    //             i++ ;
    //             j-- ;
    //         }
    //         else{
    //             return false ;
    //         }
    //     }
    //     return true ;
    // }

    // recursion 
    public static  boolean checkPalindrome(String s , int i , int j){
        if(i >= j) return true ;

        if(s.charAt(i) == s.charAt(j)){
            return checkPalindrome(s,i+1,j-1) ;
        }

        return false ;
    }
}
