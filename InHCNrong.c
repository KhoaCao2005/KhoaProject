#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int m,n,i,j;
	
	printf ("Nhap chieu dai: ");
	scanf ("%d",&m);
	printf ("Nhap chieu rong: ");
	scanf ("%d",&n);
	
	for (i=0;i<m;i++){
		for (j=0;j<n;j++){
			if (i==0 || i==m-1 || j==0 || j==n-1){
				printf ("* ");
			}
			else {
				printf ("  ");
			}
		}
			printf ("\n");
	}
	return 0;
}
