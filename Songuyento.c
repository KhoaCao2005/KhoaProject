#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int i,n,flag=0;
	
	printf ("Moi nhap so can kiem tra: ");
	scanf ("%d",&n);
	
	for(i=2;i<n;i++){
		if(n%i==0){
			flag=1;
			break;
		}
	}
	if(flag==0)
	    printf ("%d la so nguyen to",n);
	else
	    printf ("%d khong phai la so nguyen to",n);
	return 0;
}
