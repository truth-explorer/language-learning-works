#include <stdio.h>
#include <iso646.h>
#define tax1 0.15
#define tax2 0.2
#define tax3 0.25
#define extrahours 1.5     //¼Ó°à²¹³¥

main(void)
{ float salary,hours,income;
  int num;
  selection: printf("Enter the number corresponding to the desired pay rate or action:\n");
  printf("1.$8.75/h                                 2. $9.33/h\n");
  printf("3.$10.00/h                                4. $11.20/h\n");
  printf("5. quit\n");
  scanf("%d",&num);
  switch(num)
  { case 1:
      salary=8.75;
      break;
    case 2:
      salary=9.33;
      break;
    case 3:
      salary=10;
      break;
    case 4:
        salary=11.2;
        break;
    case 5:
     goto finish;
    default:
  printf("Please enter 1-5.");
  goto selection;

  }
  printf("Enter your working hours:\n");
  scanf("%f",&hours);
  income=(hours>40)?(salary*40+extrahours*(hours-40)*salary):(hours*salary);
  if (income<=300)
    income*=(1-tax1);
  else if (income>300 and income<=450)
        income=300*(1-tax1)+(income-300)*(1-tax2);
  else
    income=300*(1-tax1)+150*(1-tax2)+(income-450)*(1-tax3);
    printf("Your income is %f.",income);

   finish: return 0;

}
