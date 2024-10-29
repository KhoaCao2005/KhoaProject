#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int sumDivisors(int n){
	int sum=0,i;
	for(int i=1;i<n;i++){
		if(n%i==0){
			printf ("%d ",i);
			sum += i;
		}
	}
	return sum;
}
int main(int argc, char *argv[]) {
	int n;
	printf ("Nhap n: ");
	scanf ("%d",&n);
	
	printf ("\nSum: %d",sumDivisors(n));
	return 0;
}
