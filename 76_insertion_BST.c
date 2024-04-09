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
    return ptr;
}

void insert(struct node *root, int key)
{
    struct node *prev = NULL;
    while (root != NULL)
    {
        prev = root;
        if (key == root->data)
        {
            printf("Cannot insert %d in , already in BST", key);
            return;
        }
        else if (key < root->data)
        {
            root = root->left;
        }
        else
        {
            root = root->right;
        }
    }
    struct node*new = create_node(key) ;
    if(key<prev->data)
    {
        prev->left = new ;
    }
    else{
        prev->right = new ;
    }
}

int main()
{
    // constructing root node with its childrens
    struct node *p1 = create_node(5);
    struct node *p2 = create_node(3);
    struct node *p3 = create_node(6);
    struct node *p4 = create_node(2);
    struct node *p5 = create_node(4);
    // finally tree looks like
    //             5
    //            / \
    //           3   6
    //          / \
    //         2   4

    // linking root node with its childrens
    p1->left = p2;
    p1->right = p3;
    p2->left = p4;
    p2->right = p5;

    insert(p1,7);
    printf("%d",p3->right->data) ;
    return 0;
}
