public class Q1011 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10} ;
        int days = 5 ;
        System.out.println(shipWithinDays(weights, days));
    }
    // Optimal
    // tc : log(sum - max + 1) * n
    public static  int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i = 0 ; i < weights.length ; i++){
            sum += weights[i] ;
            max = Math.max(max,weights[i]) ;
        }

        // low and high is the range of capacity
        int low = max ;
        int high = sum ;
        while(low <= high){
            int capacity = low + (high-low)/2 ;
            int daysReq = countdays(weights,capacity) ;
            if(daysReq <= days){
                high = capacity - 1 ;
            }
            else{
                low = capacity + 1 ;
            }
        }
        return low ;
    }

    public static  int countdays(int[] weights , int capacity){
        int day = 1 ;
        int load = 0 ;
        for(int i = 0 ; i < weights.length ; i++){
            if(weights[i] + load > capacity){
                day++ ;
                load = weights[i] ;
            }
            else{
                load += weights[i] ;
            }
        }
        return day ;
    }

    // Brute
    // tc : (sum - max + 1) * n
    public static  int shipWithinDays2(int[] weights, int days) {
        int max = Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i = 0 ; i < weights.length ; i++){
            sum += weights[i] ;
            max = Math.max(max,weights[i]) ;
        }

        for(int capacity = max ; capacity <= sum ; capacity++){
            int daysReq = countdays(weights,capacity) ;
            if(daysReq <= days){
                return capacity ;
            }
        }
        return -1 ;
    }
}
