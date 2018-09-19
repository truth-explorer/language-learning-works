#include<stdio.h>
#include<limits.h>
unsigned int rotate(unsigned int,unsigned int);
char* itobs(int,char*);
int main(void)
{

return 0;

}
unsigned int rotate(unsigned int n,unsigned int b)
{
 int size = CHAR_BIT * sizeof(n);
 int loss = n>>(size-b); //±£´æËğÊ§µÄÎ»
 return (n<<b) | loss;

}
char* itobs(int n,char* ps)
{
 int size = CHAR_BIT * sizeof(n);
 for (int i = (size-1);i>=0;i--)
 {
  ps[i] = 1&n+'0';
  n>>=1;
 }
 ps[size]='\0';
 return ps;
}




