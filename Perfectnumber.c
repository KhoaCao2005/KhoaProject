#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i,n,sum=0;
	
	printf ("Moi nguoi dung nhap vao perfect number: ");
	scanf ("%d",&n);
	
	for(i=1;i<n;i++){
		if(n%i==0){
			sum += i;
		}
	}
	if(sum==n){
		printf ("%d la perfect number",n);
	}
	else
	printf ("%d khong phai perfect number",n);
	return 0;
}
