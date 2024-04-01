#include<stdio.h>
#include<stdlib.h>
struct stack{
    int top ;
    int size ;
    int *arr ;
};
int isempty(struct stack *ptr){
    if(ptr->top == -1){
       return 1  ;
    }
    else{
        return 0 ;
    }
}
int isfull(struct stack *ptr){
    if(ptr->top == ptr->size-1){
        return 1 ;
    }
    else{
        return 0 ;
    }
}
int push(struct stack *ptr , int val){
    if(isfull(ptr)){
        printf("\nstack is overflow cannot push %d to the stack !\n",val) ;
    }
    else{
        ptr->top++ ;
        ptr->arr[ptr->top] = val ;
    }
}
int pop(struct stack *ptr){
    if(isempty(ptr)){
        printf("\nstack is underflow cannot pop  from the stack\n") ;
    }
    else{
        int val = ptr->arr[ptr->top] ;
        ptr->top-- ;
        return val ;
    }
}
int stackTop(struct stack *ptr){
    return (ptr->arr[ptr->top]) ;
}
int stackBottom(struct stack *ptr){
    return (ptr->arr[0]) ;
}
int main(){
    struct stack *sp ;
    sp = (struct stack*)malloc(sizeof(struct stack)) ;
    sp->size = 10 ;
    sp->top = -1 ;
    sp->arr = (int*)malloc(sp->size * sizeof(int)) ;
    printf("\nstack has been created successfully ! \n") ;
    push(sp , 78) ;
    push(sp , 35) ;
    push(sp , 56) ;
    push(sp , 52) ;
    push(sp , 56) ;
    push(sp , 56) ;
    push(sp , 56) ;
    push(sp , 32) ;
    push(sp , 68) ;
    push(sp , 45) ; //-----> pushed 10 values
    printf("\ntop most value of this stack is %d\n",stackTop(sp));
    printf("\nthe bottom most value of this stack is %d\n", stackBottom(sp));
    return 0 ; 

}