#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void printTrapezoid(int height, int topLength, int bottomLength) {
    int space, star, diff;
    
    if (topLength > bottomLength || (bottomLength - topLength) % (height - 1) != 0) {
        printf("Khong the tao hinh thang.\n");
        return;
    }

    diff = (bottomLength - topLength) / (height - 1);

    for (int i = 0; i < height; i++) {
        space = height - i - 1;
        star = topLength + i * diff;

        for (int j = 0; j < space; j++)
            printf(" ");
        
        for (int j = 0; j < star; j++)
            printf("*");
        
        printf("\n");
    }
}

int main() {
    int height, topLength, bottomLength;

    printf("Nhap chieu cao: ");
    scanf("%d", &height);

    printf("Nhap day tren: ");
    scanf("%d", &topLength);

    printf("Nhap day duoi: ");
    scanf("%d", &bottomLength);

    printTrapezoid(height, topLength, bottomLength);

    return 0;
}
