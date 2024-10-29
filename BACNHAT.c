#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a,b;
	double x;
	printf ("Nhap vao he so a: ");
	scanf ("%d",&a);
	printf ("Nhap vao he so b: ");
	scanf ("%d",&b);
	printf ("Phuong trinh bac nhat la: %dx+%d\n",a,b);
	if(a==0)
	printf ("Ham so khong phai bac nhat");
	else if(a!=0 && b!=0){
	x = (double)-b/a;
	printf ("Nghiem cua ham so la: x = %0.1f",x);
}
	return 0;
}
	
