#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void printDiamond(int n) {

    for (int i = 1; i <= n / 2 + 1; i++) {
        for (int j = i; j < n / 2 + 1; j++) {
            printf(" ");
        }
        for (int j = 1; j <= 2 * i - 1; j++) {
            printf("*");
        }
        printf("\n");
    }

    for (int i = n / 2; i >= 1; i--) {
        for (int j = n / 2 + 1; j > i; j--) {
            printf(" ");
        }
        for (int j = 1; j <= 2 * i - 1; j++) {
            printf("*");
        }
        printf("\n");
    }
}

int main() {
    int n;

    printf("Nhap chieu cao hinh thoi: ");
    scanf("%d", &n);

    if (n % 2 == 0) {
        printf("Chieu cao phai la so le.\n");
        return 1;
    }

    printDiamond(n);

    return 0;
}
