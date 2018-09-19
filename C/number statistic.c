#include <stdio.h>


main(void)
{ char odd[100],even[100];
  int o=0,e=0,i,j;
  long num,aver_odd=0,aver_even=0;
  printf("Enter numbers please. Enter 0 to quit:\n");
    while((scanf("%ld",&num))==1)                     //get a number
    { if (num!=0)
      { if (num % 2==0)
        { even[e]=num;
          e++;                               //even numbers
        }
          else
          { odd[o]=num;
            o++;                            //odd numbers
          }
      }
       else
        break;                              //if 0, break
          printf("Enter numbers please. Enter 0 to quit:\n");
    }
    for (i=0,j=0;i<=e,j<=o;i++,j++)
    { aver_even+=even[i];
      aver_odd+=odd[j];
    }
    aver_even/=e;
    aver_odd/=o;                 //calculate the average
    printf("There are %d even numbers which average %ld. There are %d odd numbers which average %ld.",e,aver_even,o,aver_odd);
    return 0;

}
