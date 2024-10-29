#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int x,y;
	printf ("Nhap so nguyen x:");
	scanf ("%d",&x);
	printf ("Nhap so nguyen y:");
	scanf ("%d",&y);
	if(x>y)
	printf ("MAX: %d",x);
	else {
		if(x<y)
		printf ("Min: %d",x);
		else
		printf ("Bang nhau: %d",x);
	}
	return 0;
}
