#include<stdio.h>
#include<stdlib.h>


struct Node{
    int data ;
    struct Node*next ;      //----->self referencing structure 
};

void linkedlistTraversal(struct Node*ptr){
    while(ptr!=NULL){
        printf("Element : %d\n",ptr->data);
        ptr=ptr->next ;
    }
}
int main(){
    struct Node * head ;
    struct Node * second ;
    struct Node * third ;
    
    //Allocation memory for nodes in the linked list in Heap 
    head = (struct Node*)malloc(sizeof(struct Node));               //head i.e first node
    second = (struct Node*)malloc(sizeof(struct Node));
    third = (struct Node*)malloc(sizeof(struct Node));      

    //link first and second node 
    head->data = 7 ;
    head->next = second ;

    //link second node to the third node 
    second->data = 11 ;
    second->next = third ;

    //terminate the list at the third node 
    third->data  = 66 ;
    third->next = NULL ;

    linkedlistTraversal(head);
    return 0 ;
}