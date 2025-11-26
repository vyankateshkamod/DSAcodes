
import java.util.Stack;

public class Q402 {
    public static void main(String[] args) {
        String str = removeKdigits("1432219",3) ;
        System.out.println(str);
    }

    // tc : 2n + k
    // sc : 2n
    public static String removeKdigits(String num, int k) {
        int n = num.length() ;
        Stack<Character> stk = new Stack<>() ;
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && k > 0 && stk.peek() > num.charAt(i)){
                stk.pop() ;
                k-- ;
            }

            stk.push(num.charAt(i)) ;
        }

        while(k > 0){
            stk.pop() ;
            k-- ;
        }

        if(stk.isEmpty()) return "0" ;

        StringBuilder str = new StringBuilder() ;

        while(!stk.isEmpty()){
            str.append(stk.pop()) ;
        }

        while(str.length() != 0 && str.charAt(str.length()-1) == '0'){
            str.deleteCharAt(str.length()-1) ;
        }

        if(str.isEmpty()) return "0" ;

        str.reverse() ;

        return str.toString() ;
    }
}