#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int r;
	printf ("Nhap ban kinh:");
	scanf ("%d",&r);	
	printf ("Dien tich hinh tron: %5.1f\n",3.14*r*r);
	printf ("Chu vi hinh tron: %5.1f",3.14*2*r);
	return 0;
}
