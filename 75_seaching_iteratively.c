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
    return ptr ;
}

struct node *searchIter(struct node *root, int key)
{
    while (root != NULL)
    {
        if (root->data == key)
        {
            return root;
        }
        if (root->data < key)
        {
            root = root->right;
        }
        else
        {
            root = root->left;
        }
    }
    return NULL ;
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

    struct node *n = searchIter(p1, 7);
    if (n != NULL)
    {
        printf("Found : %d", n->data);
    }
    else
    {
        printf("Element not found");
    }
    return 0;
}
