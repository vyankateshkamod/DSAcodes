public class StackUsingLinkedList {
    public static void main(String[] args) {
        MyStack stk = new MyStack() ;
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.display();
        System.out.println("'Poped :'"+ stk.pop());
        stk.display();
    }
}

class MyStack{
    class StackNode{
        int data;
        StackNode next ;
        StackNode(int a){
            data = a ;
            next = null ;
        }
    }

    StackNode top ;

    void push(int a){
        StackNode temp = new StackNode(a) ;
        temp.next = top ;
        top = temp ;
    }

    int pop(){
        if(top == null){
            return -1 ;
        }
        StackNode temp = top ;
        top = top.next ;
        return temp.data ;
    }

    void display(){
        StackNode temp = top ;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next ;
        }
        System.out.println("x");
    }
}