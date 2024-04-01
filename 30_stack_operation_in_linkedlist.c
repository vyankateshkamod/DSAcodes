#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
};
int isempty(struct Node *top)
{
    if (top == NULL)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
int isfull(struct Node *top)
{
    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    if (ptr == NULL)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
struct Node *push(struct Node *top, int x) // adding element at index zero
{
    if (isfull(top))
    {
        printf("\nstack overflow");
    }
    else
    {
        struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
        ptr->data = x;
        ptr->next = top;
        top = ptr;
        return top;
    }
}
int pop(struct Node **top)
{
    if (isempty(*top))
    {
        printf("stack is underflow");
    }
    else
    {
        struct Node *ptr = *top;
        *top = (*top)->next;
        int x = ptr->data;
        free(ptr);
        return x;
    }
}
void linkedlistTraversal(struct Node *ptr)
{
    while (ptr != NULL)
    {
        printf("Element : %d\n", ptr->data);
        ptr = ptr->next;
    }
}
int peek(struct Node *top, int pos)
{ // pos->position
    struct Node *ptr = top;
    for (int i = 0; (i < pos - 1 && ptr != NULL); i++)
    {
        ptr = ptr->next;
    }
    if (ptr != NULL)
    {
        return ptr->data;
    }
    else
    {
        return -1;
    }
}
int topElement(struct Node *top)
{
    return top->data;
}
int bottom(struct Node *top)
{
    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    ptr = top;
    while (ptr != NULL && ptr->next != NULL)
    {
        ptr = ptr->next;
    }
    return ptr->data;
}
int main()
{
    struct Node *top = (struct Node *)malloc(sizeof(struct Node));
    top = NULL;
    top = push(top, 38);
    top = push(top, 35);
    top = push(top, 32);
    top = push(top, 33);
    top = push(top, 31);
    linkedlistTraversal(top);

    printf("\n\nAfter pop operation");
    printf("\n%d element is poped .\n", pop(&top));
    linkedlistTraversal(top);

    for (int i = 1; i < 5; i++)
    {
        printf("\nvalue at position %d is %d", i, peek(top, i));
    }

    printf("\n top element is %d", topElement(top));
    printf("\n bottom element is %d", bottom(top));
    return 0;
}