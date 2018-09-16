#include <stdio.h>
#include <stdlib.h>

typedef struct node * ptr;
typedef struct node
{
    char name[15];
    ptr link;
}node;

ptr head = NULL;

ptr createNode()
{
    ptr temp;
    temp = malloc(sizeof(*temp));
    printf("Enter the name\n");
    scanf("%s", temp->name);
    temp->link = NULL;
    return temp;
}

void insertFront()
{
    ptr temp;
    temp = createNode();
    
    if(head == NULL)
    {
        head = temp;
    }
    else
    {
        temp->link = head;
        head = temp;
    }
}

void delFront()
{
    ptr temp;
    temp = head;
    printf("%s\n", temp->name);
    head = head->link;
    free(temp);
}

void insertEnd()
{
    ptr temp, t;
    temp = createNode();
    t = head;
    while(t->link != NULL)
    {
        t = t->link;
    }
    t->link = temp;
    free(t);
}

void delEnd()
{
    ptr t, temp;
    temp = head;
    if(temp == NULL)
    {
        printf("Empty\n");

    }
    else
    {
        while(temp->link != NULL)
        {
            t = temp;
            temp = temp->link;
        }
    printf("%s\n", temp->name);
    free(t->link);
    t->link = NULL;
    }
}

void create()
{
    int n;
    printf("Enter the number of students:\n");
    scanf("%d", &n);
    int i;
    for(i=0; i<n; i++)
        insertFront();
}

void display()
{
    ptr temp = head;
    while(temp != NULL)
    {
        printf("%s\n", temp->name);
        temp = temp->link;
    }
}

int main()
{
    int ch1, ch2, ch3;
    while(1)
    {
        printf("Enter your choice\n1:Create\n2:Display\n3:Insert & delete from front\n4:Insert and delete from rear\n5:Exit\n");
        scanf("%d", &ch1);
        switch(ch1)
        {
            case 1 : create();break;
            case 2 : display(); break;
            case 3 : printf("Enter your choice:\n1:Insert\n2:Delete\n");
                     scanf("%d", &ch2);
                     switch(ch2)
                     {
                         case 1 : insertFront(); break;
                         case 2 : delFront(); break;
                     }break;
            case 4 : printf("Enter your choice:\n1:Insert\n2:Delete\n");
                     scanf("%d", &ch3);
                     switch(ch3)
                     {
                         case 1 : insertEnd(); break;
                         case 2 : delEnd(); break;
                     }break;
            case 5 : return 0;
                     
        }
    }
    return 0;
}
