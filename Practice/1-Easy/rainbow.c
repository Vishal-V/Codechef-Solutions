#include <stdio.h>

int main()
{
    int t,i;
    scanf("%d", &t);
    
    for(i=0; i<t; i++)
    {
        int n;
        scanf("%d", &n);
        int arr[n], p, pos, m, flag=1;
        for(p=0; p<n; p++)
        {
            scanf("%d", &arr[p]);
            if(arr[p] == 7)
                pos = p;
        }
        
        for(m=1; m<(p+1); m++)
        {
            if((arr[m]-arr[m-1]) != 0 && (arr[m]-arr[m-1]) != 1)
                flag = 0;
        }
        
        int j, k;
        
        for(j=0, k= n-1; (j<n) && (k>0); j++, k--)
        {
            if(arr[j] != arr[k])
                flag = 0;
        }
        printf(flag ? "yes\n" : "no\n");
    }
}