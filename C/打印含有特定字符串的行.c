#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define LEN 50
int main(int argc, char *argv [])
{ FILE *fp; char str[LEN];
  if (argc!=3)//检查命令行参数
  {
    fprintf(stderr,"Usage:%s filename\n",argv[0]);
    exit(EXIT_FAILURE);
  }
   if ((fp=fopen(argv[2],"r"))==NULL)
   {
     fprintf(stderr,"Error:could not open the file.\n");
     exit(EXIT_FAILURE);
   }
   while (fgets(str,50,fp)!=NULL)
   {
     if (strstr(str,argv[1])!=NULL)
        fputs(str,stdout);
   }
   if (fclose(fp)!=0)
      fprintf(stderr,"Error:could not close the file.\n");


  return 0;
}



