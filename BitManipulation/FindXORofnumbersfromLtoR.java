public class FindXORofnumbersfromLtoR {
    public static void main(String[] args) {
        System.out.println(findXOR(4, 8));
    }

    // optimal
    // tc : 1
    // sc : 1
    public static int findXOR(int l, int r) {
        int xorL = helper(l-1) ;
        int xorR = helper(r) ;
        int ans = xorL ^ xorR ;
        return ans ;
    }
    
    public static int helper(int N){
        if(N % 4 == 1){
            return 1 ;
        }
        else if(N % 4 == 2){
            return N+1 ;
        }
        else if(N % 4 == 3){
            return 0 ;
        }
        return N ;
    }

    //brute
    public static int findXOR2(int l, int r) {
        int xor = 0 ;
        for(int i = l ; i <= r ; i++){
            xor = xor ^ i ;
        }
        return xor ;
    }
}