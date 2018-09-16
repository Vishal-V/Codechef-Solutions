#include <stdio.h>

int main()
{
    int t, j, i;
    int found;
    
    scanf("%d", &t);
    for(i=0; i<t; i++)
    {
        int x, y, k, n;
        scanf("%d%d%d%d", &x, &y, &k, &n);
        found = 0;
        for(j=0; j<n; j++)
        {
            int p, c;
            
            scanf("%d%d", &p, &c);

            if(((p+y) >= x) && (c <= k))
                found = 1; 
        }
        printf( found ? "LuckyChef\n" : "UnluckyChef\n");
    }
}