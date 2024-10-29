#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a,b,c;
	printf ("Nhap vao ba canh cua tam giac:\n");
	scanf ("%d%d%d",&a,&b,&c);
	if((a+b>c) && (b+c>a) && (a+c>b)){
		if(a==b && b==c)
		printf ("La tam giac deu");
		else if(a==b || b==c || a==c)
		printf ("La tam giac can");
		else if((a*a==b*b+c*c) || (b*b==a*a+c*c) || (c*c==a*a+b*b))
		printf ("La tam giac vuong");
		else
		printf ("La tam giac thuong");
	}
	else
	printf ("Khong phai la tam giac");
	return 0;
}
