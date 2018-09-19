#include<stdio.h>
#include<string.h>
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



