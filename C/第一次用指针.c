#include<stdio.h>
void alter(int* , int* );
int main(void)
{ int x,y;
printf("Enter two numbers.Enter something other than numbers to quit.\n");
  while ((scanf("%d%d",&x,&y))==2)
  {
      alter(&x,&y);
      printf("x=%d,y=%d\n",x,y);
      printf("Enter two numbers.Enter something other than numbers to quit.\n");
      scanf("%d%d",&x,&y);
  }







return 0;


}
void alter(int *a, int *b)
{ int sum, diff;
  sum= *a + *b;
  diff= *a - *b;
  *a = sum;
  *b = diff;
}

