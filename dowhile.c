#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int x,Tong=0;
	
	do{
		printf ("Nhap cac so nguyen: ");
		scanf ("%d",&x);
		Tong += x;
	}while(x!=0);
	printf ("Tong = %d",Tong);
	return 0;
}
