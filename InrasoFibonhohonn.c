#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
void CheckFibo(int n) {
	int t1=0,t2=1,f=t1+t2;
	printf ("So Fibo nho hon hoac bang %d la: ",n);
	
	if (n >= 0) {
        printf("%d ", t1); 
    }
    
	while(f<=n){
		printf ("%d ",f);
		f=t1+t2;
		t1=t2;
		t2=f;
	}
}

int main(int argc, char *argv[]) {
	int n,i;
	
	printf ("Nhap n: ");
	scanf ("%d",&n);
	
	CheckFibo(n);
	return 0;
}
