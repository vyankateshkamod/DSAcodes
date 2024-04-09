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

void inOrder(struct node *root)
{
    if (root != NULL)
    {
        inOrder(root->left);
        printf("%d ", root->data);
        inOrder(root->right);
    }
}

struct node *inOrderPredecessor(struct node*root)
{
    root = root->left ;
    while(root->right!=NULL)
    {
        root = root->right ;
    }
    return root ;
}

struct node *deletion(struct node *root, int value)
{
    struct node *iPre;
    if (root == NULL)
    {
        return NULL;
    }
    if (root->left == NULL && root->right == NULL)
    {
        free(root);
        return NULL;
    }
    // searching for the node to be deleted
    if (value < root->data)
    {
        root->left = deletion(root->left, value);
    }
    else if (value > root->data)
    {
        root->right = deletion(root->right, value);
    }
    // deletion strategy when the node is found
    else
    {
        iPre = inOrderPredecessor(root);
        root->data = iPre->data;
        root->left = deletion(root->left, iPre->data);
    }
    return root;
}



int main()
{
    // constructing root node with its childrens
    struct node *p1 = create_node(5);
    struct node *p2 = create_node(3);
    struct node *p3 = create_node(6);
    struct node *p4 = create_node(1);
    struct node *p5 = create_node(4);
    // finally tree looks like
    //             5
    //            / \
    //           3   6
    //          / \
    //         1   4

    // linking root node with its childrens
    p1->left = p2;
    p1->right = p3;
    p2->left = p4;
    p2->right = p5;

    inOrder(p1) ;
    printf("\n") ;
    deletion(p1,3);
    inOrder(p1);

    return 0;
}