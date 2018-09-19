#include<stdio.h>
int* max_arr(const int [],int);
int main(void)
{   const int SIZE = 11; //固定数组大小
    int num=0;
    int ar[11]={0};
    printf("Create an array first.Enter no more than 10 numbers.Enter a letter to finish.\n");
    int i=0;
    while (scanf("%d",&num)==1) //输入数组
    {
       ar[i]=num;
       i++;

    }

printf("The biggest number of your array is %d.Its subscript is %d.",*max_arr(ar,SIZE),*(max_arr(ar,SIZE)+1)); //函数名就是数组名
return 0;


}
int *max_arr(const int ar[], int n) //一个返回数组的函数
{ int max=ar[0];
  int subscript=0;
  for (int i=1;i<n;i++)
   {
       if (max < ar[i])
         {
          max = ar[i];
          subscript = i;
         }
   }
   int result[2]={max,subscript};
   return result;

}
