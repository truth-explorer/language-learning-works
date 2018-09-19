#include <stdio.h>
#include<ctype.h>
#include<stdbool.h>
#include<iso646.h>
main(void)
{ char c;
  int chars=0,lines=0,words=0,spaces=0;
  bool word = false;                        //used for counting words

    printf("Enter the text please. Enter # to quit:\n");
while ((c=getchar())!='#')
{ chars++;
  if (c=='\n')
    lines++;
  if (isspace(c))
    spaces++;
   if (not isspace(c)and not word)
    { word = true;
      words++;
    }
   if (isspace(c) and word)
    word = false;                      //a word ends





}
printf("characters=%d,words=%d,lines=%d,spaces=%d",chars,words,lines,spaces);
    return 0;
}
