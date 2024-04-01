#include <stdio.h>
#include <stdlib.h>
struct stack
{
    int size;
    int top;
    char *arr;
};

int isempty(struct stack *ptr)
{
    if (ptr->top == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int isfull(struct stack *ptr)
{
    if (ptr->top == ptr->size - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void push(struct stack *ptr, char val)
{
    if (isfull(ptr))
    {
        printf("\nStack is overflow cannot push %c to the stack", val);
    }
    else
    {
        ptr->top++;
        ptr->arr[ptr->top] = val;
    }
}

char pop(struct stack *ptr)
{
    if (isempty(ptr))
    {
        printf("\nStack is Underflow , cannot pop from the the stack");
    }
    else
    {
        char val = ptr->arr[ptr->top];
        ptr->top--;
        return val;
    }
}

int parenthesisMatch(char *exp)
{ // create and initialize the stack
    struct stack *sp;
    sp->size = 100;
    sp->top = -1;
    sp->arr = (char *)malloc(sp->size * (sizeof(char)));

    for (int i = 0; exp[i] != '\0'; i++)
    {
        if (exp[i] == '(')
        {
            push(sp, '(');
        }
        else if (exp[i] == ')')
        {
            if (isempty(sp))
            {
                return 0;
            }
            else
            {
                pop(sp);
            }
        }
    }
    if (isempty(sp))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
int main()
{
    char *exp = "5*(7)";
    if (parenthesisMatch(exp))
    {
        printf("\nthe parenthesis is matching");
    }
    else
    {
        printf("\nthe parenthesis is not matching");
    }
    return 0;
}