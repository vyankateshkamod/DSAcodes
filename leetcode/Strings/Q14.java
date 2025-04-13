public class Q14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    // tc : m * n 
    // auxilary sc : 1
    // sc : m
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length ;
        int m = strs[0].length() ;
        StringBuilder ans = new StringBuilder() ;
        
        for(int i = 0 ; i < m ; i++){
            char c =  strs[0].charAt(i);
            boolean flag = true ;
            for(int j = 1 ; j < n ; j++){
                if((i >= strs[j].length()) || (strs[j].charAt(i) != c)){
                    flag = false ;
                    return ans.toString() ;
                }
            }
            if(flag == true){
                ans.append(c) ;
            }            
        }

        return ans.toString() ;
    }
}
