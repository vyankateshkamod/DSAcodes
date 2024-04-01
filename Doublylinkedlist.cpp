#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std ;

struct Node{
    int data ;
    struct Node*prev ;
    struct Node*next ;
};

struct Node* forwardtraversal(struct Node*head){
    struct Node*ptr = head ;
    while(ptr->next != NULL){
        cout<<"\t"<<ptr->data ;
        ptr = ptr->next ;
    }
    cout<<"\t"<<ptr->data<<endl ;
    head = ptr ;
    return head ;
}

struct Node*backwardtraversal(struct Node*head){
    struct Node*ptr = head ;
    cout<<"\t"<<ptr->data ;
    while(ptr->prev!=NULL){
        ptr = ptr->prev ;
        cout<<"\t"<<ptr->data ;
    }
}

int main(){
    struct Node * head ;
    struct Node * second ;
    struct Node * third ;
    struct Node* fourth ;
    struct Node* fifth ;
    
    //Allocation memory for nodes in the linked list in Heap 
    head = (struct Node*)malloc(sizeof(struct Node));               //head i.e first node
    second = (struct Node*)malloc(sizeof(struct Node));
    third = (struct Node*)malloc(sizeof(struct Node));      
    fourth = (struct Node*)malloc(sizeof(struct Node));    
    fifth = (struct Node*)malloc(sizeof(struct Node));      
  


    //link first and second node 
    head->data = 0 ;
    head->prev = NULL ;
    head->next = second ;

    //link second node to the third node 
    second->data = 1 ;
    second->prev = head ;
    second->next = third ;

    //link third node to the fourth node 
    third->data = 2 ;
    third->prev = second ;
    third->next = fourth ;

    //link fourth node to the fifth node 
    fourth->data = 3 ;
    fourth->prev = third ;
    fourth->next = fifth ;

    //terminate the list at the fifth node 
    fifth->data  = 4 ;
    fifth->prev = fourth ;
    fifth->next = NULL ;

    cout<<"forward traversal : ";
    head = forwardtraversal(head) ;
    cout<<"backward traversal : " ;
    backwardtraversal(head) ;
    
    
    return 0 ; 
}