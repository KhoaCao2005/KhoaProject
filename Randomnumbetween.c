#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void generateRandomArray(int arr[], int k, int m, int n) {
    srand(time(NULL));
    
    for (int i = 0; i < k; i++) {
        arr[i] = rand() % (n - m + 1) + m;
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int k, m, n;

    printf("Enter the number of elements (k): ");
    scanf("%d", &k);
    printf("Enter the lower bound (m): ");
    scanf("%d", &m);
    printf("Enter the upper bound (n): ");
    scanf("%d", &n);

    if (m > n) {
        printf("Invalid input: m should be less than or equal to n.\n");
        return 1;
    }

    int arr[k];
    generateRandomArray(arr, k, m, n);

    printf("Generated array: \n");
    printArray(arr, k);

    return 0;
}
