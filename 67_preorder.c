#include <stdio.h>
#include <malloc.h>
struct node
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *create_node(int data)
{
    struct node *ptr = (struct node *)malloc(sizeof(struct node));
    ptr->data = data;
    ptr->left = NULL;
    ptr->right = NULL;
}

void preOrder(struct node*root){
    if(root!=NULL){
        printf("%d ",root->data) ;
        preOrder(root->left) ;
        preOrder(root->right) ;
    }
}

void postOrder(struct node*root){
    if(root!=NULL){
        postOrder(root->left) ;
        postOrder(root->right) ;
        printf("%d ",root->data) ;
    }
}

void inOrder(struct node*root){
    if(root!=NULL){
        inOrder(root->left) ;
        printf("%d ",root->data) ;
        inOrder(root->right);
    }
}

int main()
{
    // constructing root node with its childrens
    struct node *p1 = create_node(4);
    struct node *p2 = create_node(1);
    struct node *p3 = create_node(6);
    struct node *p4 = create_node(5);
    struct node *p5 = create_node(2);
    // finally tree looks like 
    //             4
    //            / \
    //           1   6
    //          / \
    //         5   2

    // linking root node with its childrens
    p1->left = p2;
    p1->right = p3;
    p2->left = p4 ;
    p2->right = p5 ;
    
    printf("pre order traversal : "); 
    preOrder(p1) ;
    printf("\n"); 
    printf("post order traversal : ");
    postOrder(p1) ;
    printf("\n") ;
    printf("inorder traversal : ") ;
    inOrder(p1) ;
    return 0;
}