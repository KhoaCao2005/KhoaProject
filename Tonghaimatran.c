#include <stdio.h>
#include <stdlib.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i,j;
int main(int argc, char *argv[]) {
	int a[MAX][MAX],b[MAX][MAX];
	int r,c;
	printf("Enter row: ");
	scanf("%d",&r);
	printf("Enter column: ");
	scanf("%d",&c);
	for (i=0;i<r;i++){
		for (j=0;j<c;j++){
			scanf("%d",&a[i][j]);
		}
	}
	
	for (i=0;i<r;i++){
		for (j=0;j<c;j++){
			scanf("%d",&b[i][j]);
		}
	}
	for (i=0;i<r;i++){
		for (j=0;j<c;j++){
			printf("%-5d",a[i][j]+b[i][j]);
		}
		printf("\n");
	}
	return 0;
}
