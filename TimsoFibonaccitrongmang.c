#include <stdio.h>
#include <stdlib.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i;
int checkFibo(int x){
	int t1=0,t2=1,f=1;
	while(f<x){
		f=t1+t2;
		t1=t2;
		t2=f;
	}
	return f==x;
}
void findFibo(int a[],int n){
	for (i=0;i<n;i++){
		if (checkFibo(a[i])){
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
	findFibo(a,n);
	return 0;
}
