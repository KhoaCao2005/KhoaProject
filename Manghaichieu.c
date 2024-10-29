#include <stdio.h>
#include <stdlib.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i,j;
int main(int argc, char *argv[]) {
	int a[MAX][MAX];
	
	for (i=0;i<3;i++){
		for (j=0;j<4;j++){
			scanf("%d",&a[i][j]);
		}
	}
	
	for (i=0;i<3;i++){
		for (j=0;j<4;j++){
			printf("%-5d",a[i][j]);
		}
		printf("\n");
	}
	return 0;
}
