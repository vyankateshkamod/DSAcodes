package Math;


import java.util.Scanner;
public class Q7 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = obj.nextInt();
        System.out.println("Reverse number is : " + reverse(num));

    }

    public static int reverse ( int x){
        int reverse = 0;
        int remainder = 0;
        int num = x;
        while (num != 0) {
            if (reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10) {
                return 0;
            }
            remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }

        return reverse;
    }
}

