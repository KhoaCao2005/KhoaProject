#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i,x;
	
	printf ("Nhap so can tim uoc: ");
	scanf ("%d",&x);
	
	for(i=1;i<=x;i++){
		if(x%i==0){
			printf("%d ",i);
		}
	}
	return 0;
}
