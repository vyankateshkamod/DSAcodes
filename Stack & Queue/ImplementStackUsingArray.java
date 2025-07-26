public class ImplementStackUsingArray {
    public static void main(String[] args) {
        MyStack stk = new MyStack() ;
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        stk.display();
        stk.pop();
        stk.display();
    }
}


class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[10];
        top = -1;
    }

    public void push(int x) {
        if(top < arr.length-1){
            top++;
            arr[top] = x ;
        }
    }

    public int pop() {
        if(top != -1){
            int num = arr[top] ;
            arr[top] = 0 ;
            top--;
            return num ;
        }
        return -1 ;
    }

    public void display(){
        for(int i = 0 ; i <= top ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
