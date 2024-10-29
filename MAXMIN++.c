#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int x, max;
	
	scanf ("%d",&x);
	max = x;
	
	scanf ("%d",&x);
	if(x>max)
	 max = x;
	
	scanf ("%d",&x);
	if(x>max)
	 max = x;
	
	scanf ("%d",&x);
	if(x>max)
	 max = x;
	printf ("MAX: %d",max);
	return 0;
}
