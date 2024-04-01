#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std ;

struct Node{
    int data ;
    struct Node*next ;
};

void traversal(struct Node*head){
    struct Node*ptr = head ;
    while(ptr->next != head){
        cout<<"Element is  "<<ptr->data<<endl ;
        ptr = ptr->next ;
    }
    cout<<"Element is  "<<ptr->data ;
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
    head->next = second ;

    //link second node to the third node 
    second->data = 1 ;
    second->next = third ;

    //link third node to the fourth node 
    third->data = 2 ;
    third->next = fourth ;

    //link fourth node to the fifth node 
    fourth->data = 3 ;
    fourth->next = fifth ;

    //terminate the list at the fifth node 
    fifth->data  = 4 ;
    fifth->next = head ;

    traversal(head) ;
    return 0 ; 
}