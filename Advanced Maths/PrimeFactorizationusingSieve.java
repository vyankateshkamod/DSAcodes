
import java.util.*;

public class PrimeFactorizationusingSieve {

    public static void main(String[] args) {
        System.out.println(findPrimeFactors(12246));
    }

    //optimal
    // tc : O(N log log N) + log N
    // sc : O(N)
    static void sieve(int N, int[] spf) {
        for (int i = 0; i <= N; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        int[] spf = new int[N + 1]; // Only for current N
        sieve(N, spf);

        List<Integer> ans = new ArrayList<>();
        while (N != 1) {
            ans.add(spf[N]);
            N = N / spf[N];
        }

        return ans;
    }

    //better
    // tc : sqrt N
    static List<Integer> findPrimeFactors2(int N) {
        List<Integer> ans = new ArrayList<>();

        // Handle all 2s
        while (N % 2 == 0) {
            ans.add(2);
            N /= 2;
        }

        // Handle odd factors from 3 up to sqrt(N)
        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                ans.add(i);
                N /= i;
            }
        }

        // If N is still greater than 1, it's a prime
        if (N > 1) {
            ans.add(N);
        }

        return ans;
    }

}
