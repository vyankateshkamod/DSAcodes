
public class Q1832 {
    public static void main(String[] args){
        Q1832 obj = new Q1832() ;
        System.out.println(obj.checkIfPangram("vyankatesh"));
    }

    public boolean checkIfPangram(String sentence){
        boolean[]arr = new boolean[26] ;
        for(int i = 0 ; i<sentence.length() ;i++){
            arr[sentence.charAt(i)-'a'] = true ;
        }
        for(int i = 0 ; i<arr.length ;i++){
            if(!arr[i]){
                return false ;
            }
        }
        return true ;
    }
    // public boolean checkIfPangram(String sentence) {
    //     Set<Character> set = new HashSet<>() ;
    //     for(int i =0 ; i<sentence.length();i++){
    //         set.add(sentence.charAt(i)) ;
    //     }
    //     for(char i =  'a'; i <= 'z' ; i++ ){
    //         if(set.contains(i)){
    //             continue ;
    //         }else{
    //             return false ;
    //         }
    //     }
    //     return true ;

    // }
}
