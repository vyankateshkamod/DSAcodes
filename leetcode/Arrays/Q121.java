public class Q121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }


    // Optimal
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            if (profit < cost) {
                profit = cost;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return profit;
    }


    // Brute
    public static int maxProfit2(int[] prices) {
        int profit = 0 ;
        for(int i = 0 ; i < prices.length ;i++){
            for(int j = i+1 ;j<prices.length ;j++){
                if(prices[i] < prices[j]){
                    profit = Math.max(profit,prices[j] - prices[i]) ;
                }
               
            }
        }
        return profit ;
    }
}
