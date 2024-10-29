#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i,n,Sum=0;
	
	printf ("Nhap n: ");
	scanf ("%d",&n);
	
	for(i=1;i<=n;i++){
		if(i%2!=0){
			printf ("%d ",i);
			Sum = Sum + i;
		}
	}
	printf ("\nSum = %d",Sum);
	return 0;
}
