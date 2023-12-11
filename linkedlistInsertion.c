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

struct Node*InsertAtFirst(struct Node*head , int data){
    struct Node*ptr=(struct Node*)malloc(sizeof(struct Node));
    ptr->next=head ;
    ptr->data=data ;
    return ptr ;
}

struct Node*InsertAtIndex(struct Node*head , int data , int index){
    struct Node*ptr = (struct Node*)malloc(sizeof(struct Node));
    struct Node*p = head;
    int i=0;
    while(i!=index-1){                                                       //not work for index at 0
        p=p->next;
        i++;
    }
    ptr->data = data;
    ptr->next = p->next;
    p->next = ptr;
    return head ;
}

struct Node*InsertionAtEnd(struct Node*head , int data){
    struct Node*ptr = (struct Node*)malloc(sizeof(struct Node));
    struct Node*p = head ;
    while(p->next!=NULL){
        p=p->next;
    }
    p->next = ptr ;
    ptr->next = NULL ;
    ptr->data = data ;
    return head ; 
}

struct Node*InsertionAfterNode(struct Node*head , struct Node*preNode , int data){
    struct Node*ptr = (struct Node*)malloc(sizeof(struct Node));
    ptr->next = preNode->next ;
    preNode->next = ptr ;
    ptr->data = data; ;
    return head ;
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

    linkedlistTraversal(head);          //normal traversal

    printf("After Insertion At First\n");
    head = InsertAtFirst(head,28);              //Insertion at beginning
    linkedlistTraversal(head);


    printf("After Insertion At Index\n");
    head = InsertAtIndex(head,16,3);            //Insertion in between
    linkedlistTraversal(head);


    printf("After Insertion At End\n");
    head = InsertionAtEnd(head,36);
    linkedlistTraversal(head);


    printf("After , Insertion After a Node\n");
    head = InsertionAfterNode(head,second,34);                //if you want to run this operation comment out prev operations 
    linkedlistTraversal(head);
    
    return 0 ;
}