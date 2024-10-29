#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	double num1,num2,ket_qua;
	char op;
	
	printf ("Nhap so thu nhat: ");
	scanf ("%lf",&num1);
	
	printf ("Nhap so thu hai: ");
	scanf ("%lf",&num2);
	
	getchar();
	printf ("Nhap phep tinh (+,-,*,/): ");
	scanf ("%c",&op);
	
	switch (op){
		case'+':
			ket_qua = num1 + num2;
			printf ("Ket qua la: %0.1lf",ket_qua);
			break;
		case'-':
			ket_qua = num1 - num2;
			printf ("Ket qua la: %0.1lf",ket_qua);
			break;
		case'*':
			ket_qua = num1 * num2;
			printf ("Ket qua la: %0.1lf",ket_qua);
			break;
		case'/':
			if(num2!=0){
			ket_qua = num1 / num2;
			printf ("Ket qua la: %0.1lf",ket_qua);
		}
			else
			printf ("Khong chia duoc");
			break;
		default:
			printf ("Khong hop le");
	}
	return 0;

}
