#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int n,can=0;
	
	printf ("Nhap vao so can kiem tra: ");
	scanf ("%d",&n);
	
	can=(int)sqrt(n);
	if(can==sqrt(n)){
		printf ("Day la so chinh phuong");
	}
	else{
		printf ("Day khong phai so chinh phuong");
	}
	return 0;
}
