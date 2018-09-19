#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<iso646.h>
int roll_count = 0;
int rollem(int);
int roll_n_dice(int,int);
int main(void)
{ int sets,dice,sides;
  srand((unsigned int) time(0));//随机种子
  puts("Enter the number of sets. Enter q to stop:");
  while (scanf("%d",&sets)==1)
  {
    puts("How many sides and how many dices?");
    scanf("%d %d",&sides,&dice);
    printf("Here are %d sets of  %d %d-sided throws.\n",sets, dice, sides);
    for (int a=1;a<=sets;a++)
       printf("%4d",roll_n_dice(dice,sides));
    puts("\nHow many sets? Enter q to stop.");

  }
  puts("Good Fortune to you!");
  return 0;
}
int rollem(int sides)//掷一次所得点数
{
  int roll;
  roll = rand()%sides + 1;
  ++roll_count;
  return roll;
}
int roll_n_dice(int dice, int sides)//多个骰子结果求和
{
 int d;
 int total = 0;
 if (sides<2)
  {
    puts("Need at least 2 sides.");
    return -2;
  }
  if (dice<1)
  {
    puts("Need at least 1 die.");
    return -1;
  }
  for (d=1;d<=dice;d++)
    total+=rollem(sides);
  return total;

}
