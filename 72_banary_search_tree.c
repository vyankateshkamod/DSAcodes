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

void inOrder(struct node *root)
{
    if (root != NULL)
    {
        inOrder(root->left);
        printf("%d ", root->data);
        inOrder(root->right);
    }
}

int isBST(struct node *root)
{
    static struct node *prev = NULL;
    if (root != NULL)
    {
        if (!isBST(root->left))
        {
            return 0;
        }
        if (prev != NULL && root->data <= prev->data)
        {
            return 0;
        }
        prev = root;
        return isBST(root->right);
    }
    else
    {
        return 1;
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

    printf("inorder traversal : ");
    inOrder(p1);
    printf("\n%d", isBST(p1));
    return 0;
}