
public class Q42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    // optimal
    // tc : n
    // sc : 1
    public static int trap(int[] height) {
        int n = height.length ;
        int l = 0 ;
        int r = n-1 ;
        int total = 0 , leftMax = height[l] , rightMax  = height[r] ;
        while(l <= r){ // this l and r always end up meeting at peek
            if(leftMax <= rightMax){
                if(height[l] > leftMax){
                    leftMax = height[l] ;
                }
                total += leftMax - height[l] ;
                l++ ;
            }
            else{ // when rightMax < leftMax
                if(height[r] > rightMax){
                    rightMax = height[r] ;
                }
                total += rightMax - height[r] ;
                r-- ;
            }
        }
        return total ;
    }

    // better
    // tc : n
    // sc : n
    public static  int trap2(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];
        for (int i = 1; i < prefixMax.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        int[] sufixMax = new int[n];
        sufixMax[n - 1] = height[n - 1];
        for (int i = sufixMax.length - 2; i >= 0; i--) {
            sufixMax[i] = Math.max(height[i], sufixMax[i + 1]);
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = prefixMax[i];
            int rightMax = sufixMax[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return total;
    }
}
