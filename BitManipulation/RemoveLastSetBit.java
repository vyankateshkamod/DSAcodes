public class RemoveLastSetBit {
    public static void main(String[] args) {
        System.out.println(remove(6));
    }

    static int remove(int n){
        return n & n-1 ;
    }
    static int remove2(int n){
        int a = 1 ;
        while((n&a) == 0){
            a = a << 1 ;
        }
        return n ^ a ;
    }
}