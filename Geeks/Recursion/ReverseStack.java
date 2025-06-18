
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>() ;
        s.push(1) ;
        s.push(2) ;
        s.push(3) ;     // 5 4 3 2 1 
        s.push(4) ;
        s.push(5) ;

        reverse(s) ;

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

  static void reverse(Stack<Integer> s) {
        if(!s.isEmpty()){
            int top = s.pop() ;
            reverse(s) ;
            insertAtBottom(top , s) ;
        }
    }
    
    static void insertAtBottom(int element , Stack<Integer> s){
        if(s.isEmpty()){
            s.push(element) ;
        }
        else{
            int temp = s.pop() ;
            insertAtBottom(element , s) ;
            s.push(temp) ;
        }
    }
}