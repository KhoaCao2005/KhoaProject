#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i,j,x,y,a,b;
	
	printf ("Nhap vao dau hang ngang: ");
	scanf ("%d",&x);
	printf ("Nhap vao cuoi hang ngang: ");
	scanf ("%d",&y);
	printf ("Nhap vao dau hang doc: ");
	scanf ("%d",&a);
	printf ("Nhap vao cuoi hang doc: ");
	scanf ("%d",&b);
	
	printf ("  ");
	for(i=x;i<=y;i++)
	printf ("%5d",i);
	printf ("\n");
	
	for(i=x;i<=y;i++){
		printf ("%2d",i);
		for(j=a;j<=b;j++){
			printf ("%5d",i*j);
		}
		printf ("\n");
	}
	return 0;
}
