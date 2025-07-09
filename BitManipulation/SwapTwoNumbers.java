import java.util.* ;
public class SwapTwoNumbers {
    public static void main(String[] args) {
        for(Integer i : get(5, 6)){
            System.out.println(i);
        }
    }

    static List<Integer> get(int a, int b) {
        // let a = 5 , b = 6 
        a = a ^ b ; // a = 0101 ^ 0110 = 0011
        b = a ^ b ; // b = 0011 ^ 0110 = 0101
        a = a ^ b ; // a = 0011 ^ 0101 = 0110
        return new ArrayList<>(Arrays.asList(a,b)) ;
    }
}