import java.util.* ;
public class Q496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})
        ));
    }
    //tc : 2n
    // sc : 2n

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>() ;
        HashMap<Integer , Integer> map = new HashMap<>() ;

        for(int i = nums2.length-1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && stk.peek() <= nums2[i]){
                stk.pop() ;
            }

            if(stk.isEmpty()){
                map.put(nums2[i] , -1) ;
            }
            else{
                map.put(nums2[i] , stk.peek()) ;
            }

            stk.push(nums2[i]) ;
        }

        for(int i = 0 ; i < nums1.length ; i++){
            nums1[i] = map.get(nums1[i]) ;
        }

        return nums1 ;
    }
}