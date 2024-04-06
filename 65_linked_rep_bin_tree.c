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
int main()
{
    // constructing root node with its childrens
    struct node *p1 = create_node(2);
    struct node *p2 = create_node(3);
    struct node *p3 = create_node(5);
    // linking root node with its childrens
    p1->left = p2;
    p1->right = p3;
    // printing nodes
    printf("%d", p1->data);
    printf("%d", p2->data);
    printf("%d", p3->data);
    return 0;
}