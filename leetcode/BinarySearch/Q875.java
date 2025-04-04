public class Q875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }

    // TC : n * log max
    public static int minEatingSpeed( int[] piles, int h) {
        int n = piles.length ;

        int max = piles[0] ;
        for(int num : piles){
            max = Math.max(max,num) ;
        }

        int low = 1 ;
        int high = max ;
        while(low <= high){
            int k = low + (high-low)/2 ;
            long time = fun(piles,k) ;
            if(time <= h){
                high = k - 1;
            }
            else{
                low = k + 1 ;
            }
        }
        return low;
    }

    public static long fun(int piles[],int k){
        long time = 0 ;
        for(int num : piles){
            time = time + (int)Math.ceil((double)num/k) ;
            //  5/2 => 2.5 => 3.00 => 3 
        }
        return time ;
    }
}
