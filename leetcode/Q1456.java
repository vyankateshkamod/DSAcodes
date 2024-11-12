public class Q1456{
    public static void main(String[]args){
        String s = "abciiidef" ;
        System.out.println(maxVowels(s, 3));
    }
    public static int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = 0;
        int window = 0;
        int vow = 0;
        for (;r<k;r++) {
           window+= isVowel(arr[r]);
        }
        vow = window ;
        while (r<arr.length) {
            window-=isVowel(arr[l]);
            window+=isVowel(arr[r]);
            l++;
            r++;
            vow = Math.max(vow, window);
        }
        return vow;
    }

    public static int isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
    }
}