#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void reverseWords(char str[]) {
    int start = 0;
    int end = strlen(str) - 1;

    // Reverse the whole string first
    while (start < end) {
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        start++;
        end--;
    }

    // Reverse each word individually
    start = 0;
    while (str[start] != '\0') {
        // Find the end of the current word
        end = start;
        while (str[end] != ' ' && str[end] != '\0') {
            end++;
        }

        // Reverse the current word
        int left = start;
        int right = end - 1;
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }

        // Move to the next word
        start = end + 1;
    }
}

int main() {
    char str[100];

    printf("Nh?p chu?i: ");
    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = '\0'; // Xóa k? t? newline cu?i chu?i

    // Ð?o ngý?c các t? trong chu?i
    reverseWords(str);

    printf("Chu?i sau khi ð?o ngý?c t?: %s\n", str);

    return 0;
}
