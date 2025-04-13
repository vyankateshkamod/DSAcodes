public class Q151 {
    public static void main(String[] args) {
        System.out.println(reverseWords2("Hello World"));
    }
    // two pointer approach
    public static  String reverseWords(String s){
        StringBuilder sb = new StringBuilder() ;
        int n = s.length() ;
        int start = n-1 ;
        int end = n-1 ;
        for(int i = n-1 ; i >= 0 ; i--){
          while(i>0 && s.charAt(i)==' '){
              i-- ;
          }
          start = i ;
          end = i ;
          while(i>0 && s.charAt(i)!=' '){
              i-- ;
          }
          
          if(s.charAt(i)==' ') start = i+1 ;
          else if(s.charAt(i)!=' ') start = i ;
          
          sb.append(s.substring(start,end+1)) ;
          sb.append(' ') ;
        }
        return sb.toString().trim() ;
    }

    // tc : n
    // trim takes n tc , split takes n tc , and loop takes n tc 
    // sc : n
    // words takes n sc , sb takes n sc 
    public static  String reverseWords2(String s){
        String[] words = s.trim().split(" ") ;
        int n = words.length ;
        StringBuilder sb = new StringBuilder() ;
        for(int i = n-1 ; i >= 0 ; i--){
            if(words[i].length() > 0){
                sb.append(words[i]) ;
                if(i!=0){
                    sb.append(' ') ;
                }
            }
        }
        return sb.toString() ;
    }
}
