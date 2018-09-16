#include <stdio.h>


int main()
{
    int t, i, j;
    scanf("%d", &t);
    
    for(i=0; i<t; i++)
    {
        int n, min;
        scanf("%d", &n);
        int a[n];
        
        scanf("%d", &a[0]);
        min = a[0];
        
        for(j=1; j<n; j++)
        {
            scanf("%d", &a[j]);    
            if(a[j] < min)
                min = a[j];
        }
        int sum = 0;
        for(j=0; j<n; j++)
        {
            sum += (a[j] - min);
        }
        printf("%d\n", sum);
    }   
}