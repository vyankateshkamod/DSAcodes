public class Q1423 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }

    // optimal
    // tc : 2k
    // sc : 1
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length ;
        int r = n-1;
        int lsum = 0, rsum = 0 ;

        for(int i = 0 ; i < k ; i++){
            lsum += cardPoints[i];
        }

        int sum = lsum;

        for(int i = k-1 ; i >= 0 ; i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[r];
            r--;
            sum = Math.max(sum, lsum+rsum);
        }

        return sum;
    }
}