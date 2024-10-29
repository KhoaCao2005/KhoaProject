#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a,b,c,d;
	scanf ("%d%d%d%d",&a,&b,&c,&d);
	if(a>b && a>c && a>d)
	printf ("MAX: %d",a);
	if(b>a && b>c && b>d)
	printf ("MAX: %d",b);
	if(c>a && c>b && c>d)
	printf ("MAX: %d",c);
	if(d>a && d>b && d>c)
	printf ("MAX: %d",d);
	return 0;
}
