#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	char a[MAX],t;
	int i;
	gets(a);
	
	strrev(a);
	//int n=strlen(a);
	//for (i=n-1;i>=0;i--){
		//printf("%c",a[i]);
//}
    //for (i=0;i<n/2;i++){
    //	t=a[i];
    //	a[i]=a[n-1-i];
    //	a[n-1-i]=t;
	//}
	puts(a);
	return 0;
}
