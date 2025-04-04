public class Q1482{
    public static void main(String[] args) {
        int[]arr = {1,10,3,10,2} ;
        System.out.println(minDays(arr,3,1));
    }
    // Optimal 
    // tc : n * log(max - min + 1)
    public static int minDays(int[] bloomDay, int m, int k) {
        long flowers = (long) m * k ;
        if(bloomDay.length < flowers) return -1 ;

        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < bloomDay.length ; i++){
            min = Math.min(min,bloomDay[i]) ;
            max = Math.max(max,bloomDay[i]) ;
        }

        int low = min ;
        int high = max ;
        while(low <= high){
            int day = low + (high - low)/2 ;
            if(possible(bloomDay,day,m,k) == true){
                high = day - 1 ;
            }
            else{
                low = day + 1 ;
            }
        }
        return low ;
    }
    public static boolean possible(int[] bloomDay,int day,int m , int k){
        int cnt = 0 ;
        int no_bouquets = 0 ;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i] <= day){
                cnt++ ;
            }
            else{
                no_bouquets += (cnt/k) ;
                cnt = 0 ;
            }
        }
        no_bouquets += (cnt/k) ;
        if(no_bouquets >= m){
            return true ;
        }
        return false ;
    }

    // Brute 
    // tc : (max - min + 1) * n
    public static int minDays2(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (m*k)) return -1 ;

        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < bloomDay.length ; i++){
            min = Math.min(min,bloomDay[i]) ;
            max = Math.max(max,bloomDay[i]) ;
        }

        for(int day = min ; day <= max ; day++){
            if(possible(bloomDay,day,m,k) == true){
                return day ;
            }
        }
        return -1 ;
    }
}