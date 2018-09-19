#include<stdio.h>
double mean_group(const double [], int);
double mean_all(const double[][5],int);
double max(const double[][5],int);
int main(void)
{   const int ROWS = 3;
    double num[3][5]={0};
    int temp = 0;
    puts("Please enter three groups of numbers.Now enter the first group:");//输入数组
    for (int i=0;i<5;i++)
 {    scanf("%d",&temp);
      num[0][i]=temp;
 }
    puts("Now enter the second group:");
    for (int j=0;j<5;j++)
 {    scanf("%d",&temp);
      num[1][j]=temp;
 }
    puts("Now enter the third group:");
    for (int k=0;k<5;k++)
 {    scanf("%d",&temp);
      num[2][k]=temp;
 }
    for (int a=0;a<3;a++)//计算每组的平均值
      printf("The mean of this group is %f.",mean_group(num[a],5));

    printf("The mean of all numbers is %f.",mean_all(num,ROWS));//计算所有数据的平均值
    printf("The maximum is %f.",max(num,ROWS));//找出数据中的最大值



return 0;


}
double mean_group(const double num[],int n)
{ double sum = 0;
  for (int i=0;i<n;i++)
    sum+=num[i];
  double mean=sum/n;
  return mean;

}
double mean_all(const double num[][5],int rows)
{
  int r,c;
  double sum = 0;
  for (r=0;r<rows;r++)
   for (c=0;c<5;c++)
      sum+=num[r][c];
  double mean=sum/15;
  return mean;
}
double max(const double num[][5], int rows)
{
  double max = num[0][0];
  int r,c;
  for (r=0;r<rows;r++)
  {
    for (c=0;c<5;c++)
    {
      if (max<num[r][c])
         max = num[r][c];
    }
  }
  return max;
}


