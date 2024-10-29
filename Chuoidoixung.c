#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i;
int checkPalindrome(char a[]){
	int n=strlen(a);
	for (i=0;i<n/2;i++){
		if(a[i]!=a[n-1-i])
		return 0;
	}
	return 1;
}
int main(int argc, char *argv[]) {
	char a[MAX],t;
	gets(a);
	
	if(checkPalindrome(a))
	    printf("Palindrome");
	else
	    printf("No Palindrome");
	return 0;
}
