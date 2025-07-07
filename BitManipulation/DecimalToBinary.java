public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(decToBinary(5));
    }

    // tc : log n
    // sc : log n
    static String decToBinary(int n) {
        StringBuilder bn = new StringBuilder() ;
        while(n != 1){
            if(n % 2 == 1){
                bn.insert(0,'1') ;
            }
            else{
                bn.insert(0,'0') ;
            }
            n = n/2 ;
        }
        bn.insert(0,'1') ;
        return bn.toString() ;
    }
}