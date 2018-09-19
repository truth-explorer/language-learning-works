#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(void)
{ int num_words;

  puts("How many words do you wish to enter?");
  scanf("%d",&num_words);
  printf("Enter %d words now:\n",num_words);
  char temp[num_words][20];  //临时数组
  char * words[num_words];   //目标指针数组
  int i = 0;
  int status;
  while (status=scanf("%s",temp[i])==1) //用循环依次读入单词
      {
        if (status == EOF)
            break;
        words[i] =(char *) malloc(sizeof(temp[i])); //分配每个单词的动态内存
        strcpy(words[i],temp[i]);                   //将新内存指针放入指针数组
         ++i;
      }

  puts("Here are your words:");
  for (int j=0;j<num_words;j++)
    {
        printf("%s\n",words[j]);
        free(words[j]);             //打印后释放内存
    }


  return 0;
}



