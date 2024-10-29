#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a,b,c;
	double x,denta,x1,x2;
	printf ("Nhap co so a: ");
	scanf ("%d",&a);
	printf ("Nhap co so b: ");
	scanf ("%d",&b);
	printf ("Nhap co so c: ");
	scanf ("%d",&c);
	printf ("Phuong trinh bac hai la: %dx^2+%dx+%d\n",a,b,c);
	if(a==0){
		if(b==0)
		printf ("Phuong trinh khong phai bac nhat lan bac hai");
		else if(b!=0){
			x = (double)-c/b;
			printf ("Nghiem cua phuong trinh la: x = %0.1f",x);
		}
	}
	if(a!=0){
		denta=b*b-4*a*c;
		if(denta<0)
		printf("Phuong trinh bac hai vo nghiem");
		else if(denta==0){
			x = (double)-b/2*a;
			printf ("Ham so co nghiem kep: %0.1f",x);
		}
		else if(denta>0){
			x1 = (double)(-b+sqrt(denta))/(2*a);
			x2 = (double)(-b-sqrt(denta))/(2*a);
			printf ("Phuong trinh co 2 nghiem phan biet: x1 = %0.1f x2 = %0.1f",x1,x2);
		}
	}
	return 0;
}
