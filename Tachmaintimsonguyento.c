#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i;
int checkPrime(int n){
	if(n<2)
	return 0;
	for(i=2;i<n;i++){
		if(n%i==0){
			return 0;
		}
    }
    return 1;
}
int main(int argc, char *argv[]) {
	int n;
	
	printf ("Moi nhap so can kiem tra: ");
	scanf ("%d",&n);
	
	if(checkPrime(n))
	    printf ("%d la so nguyen to",n);
	else
	    printf ("%d khong phai la so nguyen to",n);
	return 0;
}
