#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void printMatrix(int n, int matrix[n][n]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int n;

    printf("Nh?p kích thý?c c?a ma tr?n vuông: ");
    scanf("%d", &n);

    int matrix[n][n];

    printf("Nh?p các ph?n t? c?a ma tr?n:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("Ph?n t? [%d][%d]: ", i, j);
            scanf("%d", &matrix[i][j]);
        }
    }

    printf("Ma tr?n ð? nh?p:\n");
    printMatrix(n, matrix);

    int sumMainDiagonal = 0, sumSecondaryDiagonal = 0;

    for (int i = 0; i < n; i++) {
        sumMainDiagonal += matrix[i][i]; // Ðý?ng chéo chính
        sumSecondaryDiagonal += matrix[i][n - 1 - i]; // Ðý?ng chéo ph?
    }

    printf("T?ng các ph?n t? trên ðý?ng chéo chính: %d\n", sumMainDiagonal);
    printf("T?ng các ph?n t? trên ðý?ng chéo ph?: %d\n", sumSecondaryDiagonal);

    return 0;
}
