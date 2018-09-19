#include<stdio.h>
#include<limits.h>
int onbits(int n)
{
 int size = CHAR_BIT * sizeof(int);
 int count = 0;
 for (int i=1;i<=size;i++)
 {
  if ((1&n)==1)
     count++;
  n>>=1;
 }
 return count;
}
int main(void)
{
puts("Enter an integer:");
int n;
while (scanf("%d",&n)==1)
{
 int count = onbits(n);
 if (count==0)
    puts("There is no bit on.");
 else if (count==1)
        puts("There is one bit on.");
 else
     printf("There are %d bits on.\n",count);

}
return 0;








}




