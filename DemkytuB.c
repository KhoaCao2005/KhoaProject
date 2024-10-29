#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	char a[MAX];
	int count=0,i;
	
	gets(a);
	
	int n=strlen(a);
	for (i=0;i<n;i++)
	   if(a[i]=='B')
	      count++;
	      
	printf("%d",count);
	return 0;
}
