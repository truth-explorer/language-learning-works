#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(void)
{ int num_words;

  puts("How many words do you wish to enter?");
  scanf("%d",&num_words);
  printf("Enter %d words now:\n",num_words);
  char temp[num_words][20];  //��ʱ����
  char * words[num_words];   //Ŀ��ָ������
  int i = 0;
  int status;
  while (status=scanf("%s",temp[i])==1) //��ѭ�����ζ��뵥��
      {
        if (status == EOF)
            break;
        words[i] =(char *) malloc(sizeof(temp[i])); //����ÿ�����ʵĶ�̬�ڴ�
        strcpy(words[i],temp[i]);                   //�����ڴ�ָ�����ָ������
         ++i;
      }

  puts("Here are your words:");
  for (int j=0;j<num_words;j++)
    {
        printf("%s\n",words[j]);
        free(words[j]);             //��ӡ���ͷ��ڴ�
    }


  return 0;
}



