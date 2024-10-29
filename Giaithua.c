#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i,n,ketqua=1;
	
	do{
	printf ("Nhap so can tinh giai thua: ");
	scanf ("%d",&n);
    } while(n<0);
	
	for(i=1;i<=n;i++){
		ketqua *= i;
	}
	printf ("Giai thua cua %d! = %d",n,ketqua);
	return 0;
}
