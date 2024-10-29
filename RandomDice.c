#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int x,y,total,count;
	time_t t;
	char c;
	srand(time(NULL));
	printf ("Dice Thrower\n============\n");
R1:	do{
	printf ("Total sought: ");
	scanf ("%d",&total);
}while(total<2||total>12);
count=0;
	do{
	t =clock();
	x =rand()%6+1;
	y =rand()%6+1;
	printf ("Result of throw %d: %d + %d\n",++count,x,y);
	while((clock()-t)/CLOCKS_PER_SEC <1);
}while ((x+y!=total));
printf ("You got your total in %d throw!",count);
R3: printf ("\nDo you want to continue? (y/n)");
fflush(stdin);
scanf ("%c",&c);
    if (c=='y')
      goto R1;
    else if(c=='n')
      goto R2;
    else
      goto R3;
R2: printf ("Goodbye!");
	return 0;
}
