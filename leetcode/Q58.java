//Length of Last Word

public class Q58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" fly me to the moon "));
    }

    public static int lengthOfLastWord(String s) {
        s=s.trim();
        char[] ch = s.toCharArray(); 
        int cnt = 0;
        for(int i = s.length()-1;i>=0 ;i--){
         
          if(ch[i]!=' '){
              cnt++;
          }
          else if(cnt>0){
             return cnt ;
          }
       
        }
        return cnt;
      }
}
