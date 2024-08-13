
public class bitManupulation {
    public static void main(String[] args) {
        System.out.println(decimaltoBinary(8));
        System.out.println(BinarytoDecimal("1000"));

        System.out.println(5 & 6) ;     //AND
        System.out.println(5 | 6) ;     //OR
        System.out.println(5 ^ 6) ;     //XOR
        System.out.println(5 << 1) ;     //LEFT SHIFT       MULTIPLY BY 2
        System.out.println(5 >> 1) ;     //RIGHT SHIFT      DIVIDE BY 2
    }

    private static String decimaltoBinary(int n) {
        if (n == 0) {
            return "0";
        }
        String result = "";
        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            result += rem;
        }

        return new StringBuilder(result).reverse().toString();
    }

    private static int BinarytoDecimal(String bin) {
        int length = bin.length();
        // bin = 100
        int result = 0;
        int m = 1;
        for (int i = length - 1; i >= 0; i--) {
            char lastCharacter = bin.charAt(i);
            int lastBit = Integer.valueOf(String.valueOf(lastCharacter));
            result = result + m * lastBit;
            m = m * 2;
        }
        return result;
    }
}
