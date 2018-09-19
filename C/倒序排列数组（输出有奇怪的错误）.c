#include<stdio.h>
int * reverse(const int [],int);
int main(void)
{   int num=0;
    int ar[10]={0};
    printf("Create an array first.Enter no more than 10 numbers.Enter a letter to finish.\n");
    int i=0;
    while (scanf("%d",&num)==1) //输入数组
    {
       ar[i]=num;
       i++;

    }

  for (int j = 0;j <= 10;j++)
            printf("%d",reverse(ar,10)[j]);

return 0;


}

int * reverse(const int ar[],int n)//建立一个倒序数组
{  int newar[10]={0};
   int j;
    for (int i=0,j=n;i<=n,j>=0;i++,j--)
    newar[i]=ar[j];

   return newar;

}
