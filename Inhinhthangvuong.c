#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void printRightTrapezoid(int height, int topLength) {
    int currentLength = topLength;

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < currentLength; j++) {
            printf("*");
        }
        printf("\n");
        currentLength++;
    }
}

int main() {
    int height, topLength;

    printf("Nhap chieu cao hinh thang: ");
    scanf("%d", &height);

    printf("Nhap do dai day tren: ");
    scanf("%d", &topLength);

    printRightTrapezoid(height, topLength);

    return 0;
}
