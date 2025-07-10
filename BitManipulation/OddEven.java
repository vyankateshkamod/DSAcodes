
public class OddEven {

    public static void main(String[] args) {
        System.out.println(isEven(15));
        System.out.println(isEven(8846));
    }

    static boolean isEven(int n) {
        if ((n & 1) == 1) {  // if odd
            return false;
        }
        return true;
    }
}
