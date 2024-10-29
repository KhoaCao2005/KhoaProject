#include <stdio.h>
#include <stdlib.h>

void fibonacci(){
    int n;
   do{
      printf("enter the amount of fibonacci you want to print out: ");
      scanf("%d", &n);
   }while(n<1);
   
   if(n==1){
    printf("1");
   }
   if(n==2){
    printf("1 1");
   }
   int t1=1, t2=1, f=1;
   int i;
   if(n>=3){
    printf("1 1 ");
   }
   for(i=3; i<=n; i++){
      f=t1+t2;
      t1=t2;
      t2=f;
      printf("%d ", f);
   }
}

void date(){
    int day, month, year;
    printf("enter day month year:");
    scanf("%d %d %d", &day, &month, &year);

    if(month==4 || month==6 || month==9 || month==11){
        if(day>30 || day<1){
            printf("invalid date");
        }

        else{
            printf("valid date");
        }
    }

    else if(month>12 || month<1){
        printf("invalid date");
    }
    
    else if(month==2){
        if(year%4==0 && year%100!=0){
            if(day<1 || day>29){
                printf("invalid date");
            }

            else{
                printf("valid date");
            }
        }
        else{
            if(day<1 || day>28){
                printf("invalid date");
            }
            
            else{
                printf("valid date");
            }
        }
    }

    else{
        if(day<1 || day>31){
            printf("invalid date");
        }

        else{
                printf("valid date");
            }
    }
}

int main(int argc, char *argv[]) {
    int c;
    printf("enter case: ");
    scanf("%d", &c);
	switch (c)
    {
    case 1:
        fibonacci();
        break;
    
    case 2:
        date();
        break;
    }
	return 0;
}
