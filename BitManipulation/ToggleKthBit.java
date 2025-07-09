public class ToggleKthBit {
    public static void main(String[] args) {
        System.out.println(toggle(13, 2));
    }

    static int toggle(int n , int k){
        return n ^ (1 << k) ;
    }
}