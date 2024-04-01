#include<stdio.h>
#include<stdlib.h>

struct stack{
    int size ;
    int top ;
    int *arr ;
};
int isempty(struct stack*ptr){
    if(ptr->top == -1){
        return 1 ;
    }
    else{
        return 0 ;
    }
}
int isfull(struct stack*ptr){
    if(ptr->top == ptr->size - 1){
        return 1 ;
    }
    else{
        return 0 ;
    }
}
void push(struct stack*ptr , int val){
    if(isfull(ptr)){
        printf("\nstack overflow cannot push %d to the stack \n",val);
    }
    else{
        ptr->top++ ;
        ptr->arr[ptr->top] = val ;
    }
}
int pop(struct stack*ptr){
    if(isempty(ptr)){
        printf("\nstack underflow cannot pop from the stack\n") ;
        return -1 ;
    }
    else{
        int val = ptr->arr[ptr->top] ;
        ptr->top-- ;
        return val ;
    }
}
int peek(struct stack*ptr,int i){
    int position = ptr->top-i+1 ;
    if(position < 0){
        printf("\nNot valid position for the stack \n") ;
        return -1 ;
    }
    else{
        return ptr->arr[position] ;
    }
}
int main(){
    struct stack *sp ;
    sp = (struct stack*)malloc(sizeof(struct stack)) ;
    sp->size = 10 ;
    sp->top = -1 ;
    sp->arr = (int*)malloc(sp->size * sizeof(int)) ;
    printf("\nstack has been created successfully\n") ;
    printf("\nBefore pushing , empty : %d",isempty(sp));
    printf("\nBefore pushing , full : %d",isfull(sp));
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
    push(sp , 47) ;
    printf("\nAfter pushing , empty : %d",isempty(sp));
    printf("\nAfter pushing , full : %d",isfull(sp));

    printf("\n\npopped %d from the stack \n",pop(sp)) ;
    printf("\n\npopped %d from the stack \n",pop(sp)) ;

    for(int j = 1 ; j <= sp->top+1 ; j++ ){
        printf("\nthe value at position %d is %d" , j , peek(sp,j));
    }
    return 0 ;
}