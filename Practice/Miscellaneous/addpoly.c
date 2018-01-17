#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct node * ptr;
typedef struct node 
{
    int exp[3];
    ptr next;
    int coeff;
}node;

ptr addTerm(ptr p, int coeff, int i, int j, int k)
{
    ptr temp;
    temp = malloc(sizeof(*temp));
    ptr p1 = p->next;
    temp->coeff = coeff;
    temp->exp[0] = i;
    temp->exp[1] = j;
    temp->exp[2] = k;
    while(p1->next != p)
    {
        p1 = p1->next;
    }
    p1->next = temp;
    temp->next = p;
    return p;
}

ptr mkHeader()
{
    ptr temp;
    temp = malloc(sizeof(*temp));
    temp->coeff = -1;
    temp->exp[0] = -1;
    temp->exp[1] = -1;
    temp->exp[2] = -1;
    temp->next = temp;
    return temp;
}

double evaluate(ptr p,int x, int y, int z)
{
    double sum = 0;
    ptr po = p->next;
    while(po != p)
    {
        sum += (po->coeff * pow(x, po->exp[1]) * pow(y, po->exp[1]) * pow(z, po->exp[2]));
        po = po->next;
    }
    return sum;
}

void print_poly(ptr p)
{
    ptr po = p->next;
    while(po != p)
    {
        printf(" %d x^%d y^%d z^%d ", po->coeff, po->exp[0], po->exp[1], po->exp[2]);
        if(po->next != p)
            printf(" + ");
        po = po->next;
    }
}

void read(ptr p, int n)
{
    int i, coeff, x, y, z;
    for(i=0; i<n; i++)
    {
        printf("Enter the coeff and exponents: \n");
        scanf("%d%d%d%d", &coeff, &x, &y, &z);
        p = addTerm(p, coeff, x, y, z);
    }
    print_poly(p);
}

ptr add(ptr p1, ptr p2)
{
    ptr temp = mkHeader();
    ptr t1 = p1->next; ptr t2 = p2->next;
    ptr t3 = p1->next; ptr t4 = p2->next;
    int flag, i;
    while(t1 != p1)
    {
        while(t2 != p2)
        {   flag = 0;
            for(i=0; i<3; i++)
                if(t1->exp[i] != t2->exp[i])
                {
                    flag = 1; break;
                }
            if(flag == 0)
            {
                temp = addTerm(temp, t1->coeff + t2->coeff, t1->exp[0], t1->exp[1], t1->exp[2]);
            }
         t2 = t2->next;   
        }
        t2 = p2->next;
        if(flag == 1)
            temp = addTerm(temp, t1->coeff, t1->exp[0], t1->exp[1], t1->exp[2]);
        t1 = t1->next;
    }
    while(t4 != p2)
    {
        while(t3 != p1)
        {   flag = 0;
            for(i=0; i<3; i++)
                if(t3->exp[i] != t4->exp[i])
                {
                    flag = 1; break;
                }
                if(flag == 0) break;
            t3 = t3->next;
        }
        if(flag == 1)
            temp = addTerm(temp, t4->coeff, t4->exp[0], t4->exp[1], t4->exp[2]);
        t4 = t4->next;
    }
    return temp;
}

int main()
{
    int ch1, x, y, z, n;
    double sum;
    ptr p, p2;
    p = mkHeader(); p2 = mkHeader();
    ptr polysum = mkHeader();
    while(1)
    {
        printf("\n1:Create\n2:Evaluate\n3:Add\n4:Exit\nEnter your choice\n");
        scanf("%d", &ch1);
        switch(ch1)
        {
            case 1 : printf("Enter the number of terms\n");
                     scanf("%d", &n);
                     read(p,n);
                     break;
            case 2 : printf("Enter the values of x, y and z: \n");
                     scanf("%d%d%d", &x, &y, &z);
                     printf("%f\n",sum = evaluate(p,x,y,z));
                     break;
            case 3 : printf("Enter the number of terms in p2:\n");
                     scanf("%d", &n);
                     read(p2,n);
                     polysum = add(p,p2);
                     print_poly(polysum);
                     break;
            case 4 : return 0;
        }
    }
    return 0;
    
}


























