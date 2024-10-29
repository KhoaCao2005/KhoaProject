#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a[100];
	int i,n,min;
	
	printf ("Number of elements in the array: ");
	scanf ("%d",&n);
	for (i=0;i<n;i++){
		printf ("a[%d]= ",i);
		scanf ("%d",&a[i]);
	}
	min = a[0];
    for (i=1;i<n;i++){
    	if (min>a[i]){
    		min = a[i];
		}
	}
	printf ("Min: %d ",min);
	return 0;
}
