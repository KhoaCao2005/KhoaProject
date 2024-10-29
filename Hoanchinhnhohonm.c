#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int main(int argc, char *argv[]){
	int i,n,m,sum;
	printf ("Nhap m: ");
	scanf ("%d",&m);
	for(n=1;n<=m;n++){
		sum=0;
		for(int i=1;i<n;i++){
			if(n%i==0){
				sum += i;
			}
		}
		if(sum==n){
			printf ("%d",n);
		}
	}
	return 0;
}
	
