public class BinarytoDecimal {
    public static void main(String[] args) {
        System.out.println(binaryToDecimal2("00100"));
    }

    // optimal
    // tc : n
    // sc : 1
    public static int binaryToDecimal(String b) {
        int n = b.length() ;
        int ans = 0 ;
        int pow = 1 ;
        for(int i = n-1 ; i >= 0 ; i--){
            ans = ans + (b.charAt(i) - '0') * pow ;
            pow = pow * 2 ;
        }
        return ans ;
    }

    // tc : n log bitIdx
    // sc(recursive) : no.of set bits * log bitIdx
    public static  int binaryToDecimal2(String b) {
        int n = b.length() ;
        int num = 0 ;
        for(int i = 0 ; i < n ; i++){
            int bitIdx = n - i - 1 ;        //1 0 1 0
            if(b.charAt(i) == '1'){        // 3 2 1 0
                num = num + calculatePower(2,bitIdx) ;
            }
        }
        return num ;
    }
    
    public static  int calculatePower(int base , int exponent){
        if(exponent == 0){
            return 1 ;
        }
        if(exponent % 2 == 0){
            return calculatePower(base*base , exponent/2) ;
        }
        else{
            return base * calculatePower(base , exponent-1) ;
        }
    }
}