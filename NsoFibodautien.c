#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
void PrintFibo (int n) {
	int a=0,b=1,c;
	
	printf ("%d so Fibo dau tien la: ",n);

    for (int i = 0; i < n; i++) {
        if (i == 0) {
            printf("%d ", a); 
        } else if (i == 1) {
            printf("%d ", b); 
        } else {
            c = a + b;
            a = b;
            b = c;
            printf("%d ", c); 
        }
    }
}
int main(int argc, char *argv[]) {
	int n;
	
	printf ("Nhap n: ");
	scanf ("%d",&n);
	
	PrintFibo(n);
	return 0;
}
