#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int x;
	printf ("Nhap cac thu tu 2 den 8: ");
	scanf ("%d",&x);
	switch(x){
		case 2:
			printf("Monday");
			break;
		case 3:
			printf("Tuesday");
			break;
		case 4:
			printf("Wednesday");
			break;
		case 5:
			printf("Thursday");
			break;
		case 6:
			printf("Friday");
			break;
		case 7:
			printf("Saturday");
			break;
		case 8:
			printf("Sunday");
			break;
		default:
			printf("Khong hop le");
	} 
	return 0;
}
