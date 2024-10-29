#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int UCLN(int a,int b){
	while(a!=b){
		if(a>b)
		 a -= b;
		else
		 b -= a;
	}
	return a;
}
int BCNN(int a,int b){
	return (a*b)/UCLN(a,b);
}
int main(int argc, char *argv[]) {
	int a,b;
	
	scanf ("%d%d",&a,&b);
	
	printf ("UCLN: %d",UCLN(a,b));
	printf ("\nBCNN: %d",BCNN(a,b));
	
	return 0;
}
