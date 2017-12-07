#include <stdio.h>
#define MAX 20

int createit(int num);
void linear_probe(int a[], int key, int num);
void display(int a[]);

int main(void)
{
    int a[MAX], num, key=0, i;
    int ans;
    printf("\nCollision handling by linear probing");
    for(i=10; i<MAX; i++)
        a[i] = -1;
    do
    {
        printf("\nEnter four digit number:");
        scanf("%d", &num);
        key = createit(num);
        linear_probe(a,key,num);
        printf("Do you wish to continue?");
        scanf("%d", &ans);
    } while(ans != -1);
    display(a);
}
int createit(int num)
{
    int key;
    key = num % 100;
    return key;
}

void linear_probe(int a[], int key, int num)
{
    int flag=0, i, count = 10;
    if(a[key] == -1)
        a[key] = num;
    else
    {
        for(i=10; i<MAX; i++)
        {
            if(a[i] != -1)
                count++;
        }
        if(count == MAX)
        {
            printf("Hash table is full\n");
            display(a);
            return;
        }
        for(i=key+1; i<MAX; i++)
        {
            if(a[i] == -1)
            {
                a[i] = num;
                flag = 1;
                break;
            }
        }
        for(i=10; (i<key) && (flag==0); i++)
        {
            if(a[i] == -1)
            {
                a[i] = num;
                flag=1;
                break;
            }
        }
    }
}

void display(int a[])
{
    int i;
    printf("The hash table is:\n key/Index\tEmployee ID\n");
    for(i=10; i<MAX; i++)
        printf("\n%d\t\t%d", i, a[i]);
}















