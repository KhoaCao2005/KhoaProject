#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void convertToUpperCase(char str[]) {
    for (int i = 0; i < strlen(str); i++) {
        str[i] = toupper(str[i]);
    }
}

// Function to reverse a string
void reverseString(char str[]) {
    int left = 0;
    int right = strlen(str) - 1;
    
    while (left < right) {
        // Swap characters
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
        
        left++;
        right--;
    }
}

int main() {
    char str[100];

    printf("Nh?p chu?i: ");
    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = '\0'; // Xóa k? t? newline cu?i chu?i

    // Chuy?n chu?i thành ch? hoa
    convertToUpperCase(str);

    // Ð?o chu?i
    reverseString(str);

    printf("Chu?i sau khi vi?t hoa và ð?o ngý?c: %s\n", str);

    return 0;
}
