#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a[100];
	int i,n,sum=0;
	
	printf ("Number of elements in the array: ");
	scanf ("%d",&n);
	for (i=0;i<n;i++){
		printf ("a[%d]= ",i);
		scanf ("%d",&a[i]);
	}
	printf ("Even: ");
    for (i=0;i<n;i++){
    	if (a[i]%2==0){
    	sum += a[i];
		printf ("%d ",a[i]);
	}
	}
	printf ("\nSum = %d",sum);
	return 0;
}
