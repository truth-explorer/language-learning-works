#include<stdio.h>
#include<string.h>
char *s_gets(char *,int );
char *deletespace(char*);
int main(void)
{ const int SIZE = 1000;
  char a[SIZE];
  char *b;
  puts("Enter a string please.Enter q to quit:");
  s_gets(a,1000);
  while (*a!='q')
  {
   b = deletespace(a);
   puts(b);
   puts("Enter a string please.Enter q to quit:");
   s_gets(a,1000);
  }
  return 0;
}
char *deletespace(char *a)
  { char *space;
    while (strchr(a,' ')!=NULL)
    {  space = strchr(a,' ');
       while (*space != '\0')
       {
        *space = *(space+1);
        space++;
        }

    }
     return a;
  }
char * s_gets(char *st, int n)
{  char * str,* find;
   str = fgets(st,n,stdin);
   if(str)
   {
     if (find=strchr(st,'\n'))
        *find='\0';
     else
         while (getchar()!='\n')
               continue;

    }

   return str;


}


