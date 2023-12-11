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

struct Node*deletefirst(struct Node*head){
    struct Node*ptr;
    ptr = head ; 
    head = head->next ;
    free(ptr);
    return head ;
}

struct Node*deleteindex(struct Node*head , int index){
    struct Node*p = head ;
    struct Node*q = head->next ;
    int i = 0 ;
    while(i!=index-1){
        p = p->next ;
        q = q->next ;
        i++ ;
    }
    p->next = q->next ;
    free(q);
    return head ;
}

struct Node*deletelast(struct Node*head){
    struct Node*p = head ;
    struct Node*q = head->next ;
    int i = 0 ;
    while(q->next!=NULL){
        p = p->next ;
        q = q->next ;
    }
    p->next = NULL ;
    free(q);
    return head ;
}

struct Node*deleteValue(struct Node*head , int val){
    struct Node*p = head ;
    struct Node*q = head->next ;
    while(q->data!=val && q->next!=NULL){
        p = p->next ;
        q = q->next ;
    }
    if(q->data==val){
        p->next = q->next ;
        free(q) ;
        return head ; 
        printf("After deleting value \n");
    }else{
        printf("element not found ");
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
    fifth->next = NULL ;

    linkedlistTraversal(head);          //normal traversal

    printf("After deleting first node\n");
    head = deletefirst(head);
    linkedlistTraversal(head);

    printf("After deleting node at Index\n");
    head = deleteindex(head,2);
    linkedlistTraversal(head);

    printf("After deleting last node \n");
    head = deletelast(head);
    linkedlistTraversal(head);

    //deleting by value 
    printf("which element you want to delete ? : ");
    int val ;
    scanf("%d",&val);
    if(val==head->data){
        head = deletefirst(head);
    }else{
        head = deleteValue(head , val);
    }
    linkedlistTraversal(head);

    return 0 ;
}
