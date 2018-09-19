#include<stdio.h>
#include<stdlib.h>
#include<stdarg.h>
void show_array(const double [], int);
double * new_d_array(int, ...);
int main(void)
{
 double* p1, * p2;
 p1 = new_d_array(5,1.2,2.3,3.4,4.5,5.6);
 p2 = new_d_array(4,100.0,20.00,8.08,-1890.0);
 show_array(p1, 5);
 show_array(p2, 4);
 free(p1);
 free(p2);

 return 0;

}
double * new_d_array(int n, ...)
{
 double* p;
 va_list ar;
 va_start(ar,n);
 p = (double*) malloc(n*sizeof(double));
 for (int i=0;i<n;i++)
       p[i] = va_arg(ar,double);
 va_end(ar);
 return p;

}
void show_array(const double ar[], int n)
{
 for (int i=0;i<n;i++)
    printf("%g ",ar[i]);
    putchar('\n');
}


