#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a;
	int b;
	printf ("Nhap chieu dai:");
	scanf ("%d",&a);
	printf ("Nhap chieu rong:");
	scanf ("%d",&b);	
	printf ("Dien tich: %d\n",a*b);
	printf ("Chu vi: %d", (a+b)*2);
	return 0;
}
