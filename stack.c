/* Implementing stack using arrays 
--> fixed size array creation 
--> top element 
struct stack{
    int size ;
    int top ;
    int*arr ;
}
stuct stack s ;
s.size = 80 ;
s.top = -1 ;
s.arr = (int*)malloc(s.size*sizeof(int)) ;
*/

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
int isfull(struct stack *ptr){
    if(ptr->top == ptr->size-1){
        return 1 ;
    }
    else{
        return 0 ;
    }
}
int main(){
    struct stack *s ;
    s->size = 5 ;
    s->top = -1 ;
    s->arr = (int*)malloc(s->size * sizeof(int)) ;
    
    //check if stack is empty 
    if(isempty(s)){
        printf("\nthe stack is empty") ;
    }
    else{
        printf("\nstack is not empty") ;
    }

    s->arr[0] = 67 ;
    s->top++ ;
     s->arr[1] = 56 ;
    s->top++ ;
     s->arr[2] = 46 ;
    s->top++ ;
     s->arr[3] = 576 ;
    s->top++ ;
     s->arr[4] = 52 ;
    s->top++ ;


    // printf("\nstack elements are : ") ;
    // for(int i = 0 ; i < s->size ; i++){
    //     printf("%d",s->arr[i]) ;
    //     printf("\t") ;
    // }

    if(isfull(s)){
        printf("\nthe stack is full") ;
    }
    else{
        printf("\nstack is not full") ;
    }
    return 0 ; 
}