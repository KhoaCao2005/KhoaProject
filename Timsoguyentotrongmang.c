#include <stdio.h>
#include <stdlib.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i;
int checkPrime(int x){
	if (x<2)
	    return 0;
	for (i=2;i<x;i++){
		if (x%i==0){
		    return 0;
		}
	}
	return 1;
}
void findPrime(int a[],int n){
	for (i=0;i<n;i++){
		if (checkPrime(a[i])){
			printf ("%d ",a[i]);
		}
	}
}
int main(int argc, char *argv[]) {
	int a[MAX],n;
	printf ("Enter the number of elements: ");
	scanf ("%d",&n);
	for (i=0;i<n;i++)
	    scanf ("%d",&a[i]);
	findPrime(a,n);
	return 0;
}
