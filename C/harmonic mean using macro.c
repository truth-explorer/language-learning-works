#include<stdio.h>
#define HARMEAN(X,Y) (2.0*(X)*(Y)/((X)+(Y)))
int main(void)
{
 double x,y,ans;
 puts("Enter two numbers,q to quit: ");
 while (scanf("%lf %lf",&x,&y)==2)
     {
      ans = HARMEAN(x,y);
      printf("The harmonic mean of %g and %g is %g.",x,y,ans);
      puts("Enter two numbers, q to quit:");

     }
 return 0;

}


