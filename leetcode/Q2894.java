// 2894. Divisible and Non-divisible Sums Difference

// You are given positive integers n and m.

// Define two integers, num1 and num2, as follows:

// num1: The sum of all integers in the range [1, n] that are not divisible by m.
// num2: The sum of all integers in the range [1, n] that are divisible by m.
// Return the integer num1 - num2.


public class Q2894 {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(23,32)) ;
    }
    public static int differenceOfSums(int n, int m) {
        int num1 =0;
        int num2 =0;
        for(int i=0;i<=n;i++){
            if(i%m==0){
                num2 = num2+i ;
            }
            else{
                num1 = num1 + i ;
            }
        }
        return num1 - num2 ;
    }
}
