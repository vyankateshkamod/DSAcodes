public class Q152 {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, 0, 5 };
        System.out.println(maxProduct(arr));
    }

    // optimal
    // tc : n
    // sc : 1
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int sufix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (sufix == 0)
                sufix = 1;
            prefix *= nums[i];
            sufix *= nums[n - 1 - i];
            maxProd = Math.max(maxProd, Math.max(prefix, sufix));
        }
        return maxProd;
    }

    // better
    // tc : n2
    // sc : 1
    public static int maxProduct2(int[] nums) {
        int n = nums.length;

        int prod = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp_prod = nums[i];

            prod = Math.max(prod, temp_prod);

            for (int j = i + 1; j < n; j++) {
                temp_prod *= nums[j];
                prod = Math.max(prod, temp_prod);
            }

        }

        return prod;
    }
}
