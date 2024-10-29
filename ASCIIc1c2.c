#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i;
	char c1,c2;
	
	printf ("Nhap ky tu 1: ");
	scanf ("%c",&c1);
	printf ("Nhap ky tu 2: ");
	fflush (stdin);
	scanf ("%c",&c2);
	
	for(i=c1;i<=c2;i++){
		printf ("%d  %x  %c\n",i,i,i);
	}
	return 0;
}
