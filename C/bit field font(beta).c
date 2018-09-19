#include<stdio.h>
#include<string.h>
#define ID_MASK 0xFF
#define SIZE_MASK 0x7F00
struct format{
unsigned int ID:8;
unsigned int size:7;
unsigned int alignment:2;
unsigned int bold:1;
unsigned int italic:1;
unsigned int underline:1;
};
struct format test={1,12,0,0,0,0};
void showformat(void);
void show_menu(void);
char get_choice(const char *);
void get_ID(void);
void get_size(void);
int main(void)
{
 showformat();
 show_menu();
 char ch;
 while (ch = get_choice("fsabiuq")!='q')
 {
  printf("%c",ch);
  switch (ch)
  {
   case 'f' : get_ID(); break;
   case 's' : get_size(); break;
   case 'a' : get_align();  break;
   case 'b' : test.bold = ~test.bold; break;
   case 'i' : test.italic = ~test.italic; break;
   case 'u' : test.underline = ~test.underline; break;
  }
  showformat();
  show_menu();
 }
 puts("Bye!");


return 0;

}
void showformat(void)
{
 printf("\n%4s %4s %9s %3s %3s %3s\n", "ID", "SIZE", "ALIGNMENT", "B", "I", "U");
 printf("%4lu  %4lu",test.ID,test.size);
 switch(test.alignment)
 {
  case 0: printf("%7s", "left"); break;
  case 1: printf("%7s", "right"); break;
  case 2: printf("%7s", "center"); break;
  default: printf("%7s", "unknown"); break;
 }
 printf("%8s %3s %3s\n\n", test.bold == 1? "on" : "off",test.italic == 1? "on" : "off",test.underline == 1 ? "on" : "off");

}
void show_menu(void)
{
puts("f)change font s)change size  a)change alignment");
puts("b)toggle bold i)toggle italic u)toggle underline");
puts("q)quit");
}
char get_choice(const char * str)
{
 char ch=getchar();
 while (getchar() != '\n')
       continue;
 while (strchr(str,ch)==NULL)
 {
  puts("Choice invalid,please choose again.");
  ch=getchar();
  while (getchar() != '\n')
        continue;
 }
 return ch;
}
void get_ID(void)
{
 unsigned int id;
 puts("Please enter the new font ID(0~255):");
 scanf("%u",&id);
 test.ID = id & ID_MASK;
 while (getchar() != '\n')
       continue;
}
void get_size(void)
{
 unsigned int size;
 puts("Please enter font size(0~127):");
 scanf("%u",&size);
 test.size = size & SIZE_MASK;
 while (getchar() != '\n')
       continue;
}
void get_align(void)
{
 puts("Select alignment:");
 puts("l)left c)center r)right");
 char ch = get_choice("lcr");
 switch (ch)
 {
  case 'l': test.alignment = 0; break;
  case 'r': test.alignment = 1; break;
  case 'c': test.alignment = 2; break;
 }
}



