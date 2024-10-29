#include <stdio.h>
#include <math.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int chon;
	double a,b,r,h,Hinh_vuong,Hinh_chu_nhat,Hinh_tron,Hinh_tam_giac_vuong,Hinh_thang;
	
	printf ("Chuong trinh tinh dien tich cac hinh");
	printf ("1. Hinh vuong\n");
	printf ("2. Hinh chu nhat\n");
	printf ("3. Hinh tron\n");
	printf ("4. Hinh tam giac vuong\n");
	printf ("5. Hinh thang\n");
	printf ("Hay chon hinh can tinh (1-5): ");
	scanf ("%d", &chon);
	
	switch (chon) {
		case 1:
			printf ("Nhap canh hinh vuong: ");
			scanf ("%lf",&a);
			Hinh_vuong = (double)a*a;
			printf ("Dien tich hinh vuong la: %0.2lf",Hinh_vuong);
			break;
		case 2:
			printf ("Nhap chieu dai hinh chu nhat: ");
			scanf ("%lf",&a);
			printf ("Nhap chieu rong hinh chu nhat: ");
			scanf ("%lf",&b);
			Hinh_chu_nhat = (double)a*b;
			printf ("Dien tich hinh chu nhat la: %0.2lf",Hinh_chu_nhat);
		case 3:
			printf ("Nhap ban kinh hinh tron: ");
			scanf ("%lf",&r);
			Hinh_tron = (double)M_PI*r*r;
			printf ("Dien tich hinh tron la: %0.2lf",Hinh_tron);
			break;
		case 4:
			printf ("Nhap canh day tam giac vuong: ");
			scanf ("%lf",&a);
			printf ("Nhap chieu cao tam giac vuong: ");
			scanf ("%lf",&h);
			Hinh_tam_giac_vuong = (double)(a*h)/2;
			printf ("Dien tich tam giac vuong la: %0.2lf",Hinh_tam_giac_vuong);
			break;
		case 5:
			printf ("Nhap day lon hinh thang: ");
			scanf ("%lf",&a);
			printf ("Nhap day nho hinh thang: ");
			scanf ("%lf",&b);
			printf ("Nhap chieu cao hinh thang: ");
			scanf ("%lf",&h);
			Hinh_thang = (double)((a+b)*h)/2;
			printf ("Dien tich hinh thang la: %0.2lf",Hinh_thang);
			break;
		default:
			printf ("Yeu cau khong hop le");
	}
	return 0;
}
