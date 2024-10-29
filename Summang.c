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
    for (i=0;i<n;i++){
		sum += a[i];
	}
	printf ("Sum = %d",sum);
	return 0;
}
