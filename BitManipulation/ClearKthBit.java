public class ClearKthBit {
    public static void main(String[] args) {
        System.out.println(clear(13, 2));
    }

    static int clear(int n , int k){
        return n & ~(1 << k) ;
    }
}