public class CheckKthBit {
    public static void main(String[] args) {
        System.out.println(checkKthBit(4, 2));
    }

    // using left shift
    static boolean checkKthBit(int n, int k) {
        if((n & (1 << k)) != 0){
            return true ;
        }
        return false ;
    }

    // using right shift
    static boolean checkKthBit2(int n, int k) {
        if(((n >> k) & 1) == 1 ){
            return true ;
        }
        return false ;
    }
}