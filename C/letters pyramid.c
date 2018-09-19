#include <stdio.h>
main(void)
{ char ch,i,j,k;
  int h,space,l;
  char up,down='A';
  printf("Please enter capital letters");
  scanf("%c",&ch);
   space= ch-'A';

for(i='A';i<=ch;i++,up++,down++,space--)
{
  for(h=1;h<=(space+1);h++)
 {printf(" ");}
  for(j='A';j<=up;j++)
  {printf("%c",j);}
  for(k=down-1;k>='A';k--)
  {printf("%c",k);}
  for(l=1;l<=space;l++)
  {printf(" ");}
  printf("\n");
}

}
