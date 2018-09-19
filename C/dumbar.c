#include <stdio.h>
#include<string.h>
#define dumbar 150
main(void)
{ int friends=5,i=1;
  int week[50];
 while(friends<=dumbar)
  {
    friends=(friends-i)*2;
    week[i-1]=friends;
    printf("week%d:%d\n",i,week[i-1]);
    i++;

  }

return 0;
}
