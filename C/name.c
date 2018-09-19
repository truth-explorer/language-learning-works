#include <stdio.h>
#include <string.h>
main(void)
{ char firstname[20];
  char lastname [20];
  unsigned short w1;
  unsigned short w2;
  printf("Enter your first name:\n");
  scanf("%s",firstname);
  printf("Enter your last name:\n");
  scanf("%s",lastname);
  printf("%s %s\n",firstname,lastname);
  w1=strlen(firstname); w2=strlen(lastname);
  printf("%*hu %*hu\n",w1,w1,w2,w2);
  printf("%s %s\n",firstname,lastname);
  printf("%-*hu %-*hu",w1,w1,w2,w2);
}
