#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int kwh;
	double gia_tien;
	printf ("Chuong trinh tinh tien dien (kwh/dong)\n");
	printf ("Nhap vao so kwh: ");
	scanf ("%d",&kwh);
	if(kwh<=50){
	gia_tien = kwh*1806;
	printf ("Gia tien dien la: %0.0lf",gia_tien);
}
	else if (kwh<=100){
	gia_tien = 50*1805+(kwh-50)*1866;
	printf ("Gia tien dien la: %0.0lf",gia_tien);
}
    else if (kwh<=200){
    gia_tien = 50*1805+50*1866+(kwh-100)*2167;
    printf ("Gia tien dien la: %0.0lf",gia_tien);
}
    else if (kwh<=300){
    gia_tien = 50*1805+50*1866+100*2167+(kwh-200)*2729;
    printf ("Gia tien dien la: %0.0lf",gia_tien);
}
    else if (kwh<=400){
    gia_tien = 50*1805+50*1866+100*2167+100*2729+(kwh-300)*3050;
    printf ("Gia tien dien la: %0.0lf",gia_tien);
}
    else if (kwh>=401){
    gia_tien = 50*1805+50*1866+100*2167+100*2729+100*3050+(kwh-400)*3151;
    printf ("Gia tien dien la: %0.0lf",gia_tien);
}
	return 0;
}
