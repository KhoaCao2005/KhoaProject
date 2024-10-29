#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int main(int argc, char *argv[]) {
	char a[MAX];
	char* p;
	gets(a);
	
	p = strstr(a,"B");
	while(p!=NULL){
		strcpy(p,p+1);
		p = strstr(a,"B");
	}
	puts(a);
	return 0;
}
