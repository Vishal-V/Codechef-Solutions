#include <stdio.h>

int main()
{
    int t, i;
    
    scanf("%d", &t);
    int n, c, candy;
    
    for(i=0; i<t; i++)
    {
        scanf("%d", &n);
        scanf("%d", &c);
        int arr[n], sum=0;
        for(candy = 0; candy<n; candy++)
        {
            scanf("%d", &arr[candy]);
            sum += arr[candy];
        }
        if(sum <= c)
            printf("Yes\n");
        else
            printf("No\n");
    }
    return 0;
}