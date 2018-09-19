#include<stdio.h>
#include<iso646.h>
int main(void)
{ printf("Enter the operation of your choice:\n");
  printf("a. add        s. subtract\n"
         "m. multiply   d.divide\n"
         "other letters.quit\n");
  char ch;

  while ((ch=getchar())=='a' or ch=='s' or ch=='m' or ch=='d')
  {
    float x,y,z;
    printf("Enter the first number\n");
    scanf("%f",&x);
    printf("Enter the second number\n");
    scanf("%f",&y);
    switch(ch)
  { case 'a':
      z=x+y;
      printf("%f+%f=%f\n",x,y,z);
      break;
    case 's':
       z=x-y;
       printf("%f-%f=%f\n",x,y,z);
       break;
    case 'm':
        z=x*y;
        printf("%f*%f=%f\n",x,y,z);
        break;
    case 'd':
        z=x/y;
        printf("%f/%f=%f\n",x,y,z);
        break;


    }

  printf("Enter the operation of your choice:\n");
  printf("a. add        s. subtract\n"
         "m. multiply   d.divide\n"
         "other letters.quit\n");
   ch=getchar();


  }
 printf("Bye.");
 return 0;
}
