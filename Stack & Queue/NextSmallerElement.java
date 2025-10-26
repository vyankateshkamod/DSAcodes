import java.util.* ;

public class NextSmallerElement {
    public static void main(String[] args) {
        System.out.println(nextSmallerEle(new int[]{4, 8, 5, 2, 25}));
    }

    static ArrayList<Integer> nextSmallerEle(int[] arr) {
     ArrayList<Integer> list = new ArrayList<>() ;
     Stack<Integer> stk = new Stack<>() ;
     for(int i = arr.length-1 ; i >= 0 ; i--){
         while(!stk.isEmpty() && stk.peek() >= arr[i]){
             stk.pop() ;
         }
         
         if(stk.isEmpty()){
             list.add(-1) ;
         }
         else{
             list.add(stk.peek()) ;
         }
         
         stk.push(arr[i]) ;
     }
     
     Collections.reverse(list) ;
     
     return list ;
    }
}