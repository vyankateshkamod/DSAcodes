//First Letter to Appear Twice
import java.util.HashSet ;
import java.util.Set;
public class Q2351 {
    public static void main(String[] args){
        Q2351 obj = new Q2351() ;
        System.out.println(obj.repeatedCharacter("vyankatesh")) ;
    }

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>() ;              // time complexity = O(n)
        for(int i =0 ; i < s.length() ;i++){                // space complexity = O(1) because there are only 26 characters to store
            if(set.contains(s.charAt(i))){
                return s.charAt(i) ;
            }
            else{
                set.add(s.charAt(i)) ;
            }
        }
        return ' ' ;
    }
}



//public char repeatedCharacter(String s) {
//    int l = 0;
//    int r = 1;
//    char letter = ' ';
//    for (r = 1; r < s.length(); r++) {
//
//        for (l = 0; l < r; l++) {
//            if (s.charAt(l) == s.charAt(r)) {
//                letter = s.charAt(r);
//                return letter ;
//            }
//        }
//
//    }
//    return ' ';
//}

