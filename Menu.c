#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

double calculateTriangleArea(double a, double b, double c) {
    double s = (a + b + c) / 2; 
    return sqrt(s * (s - a) * (s - b) * (s - c));
}

int isPalindrome(char str[]) {
    int left = 0;
    int right = strlen(str) - 1;
    while (left < right) {
        if (!isalnum(str[left])) {
            left++;
        } else if (!isalnum(str[right])) {
            right--;
        } else if (tolower(str[left]) != tolower(str[right])) {
            return 0;
        } else {
            left++;
            right--;
        }
    }
    return 1;
}

int main() {
    int choice;
    do {
        printf("\nMenu:\n");
        printf("1. Calculate the area of a triangle\n");
        printf("2. Check if a string is a palindrome\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1: {
                double a, b, c;
                printf("Enter the lengths of the three sides of the triangle: ");
                scanf("%lf %lf %lf", &a, &b, &c);

                if (a + b > c && a + c > b && b + c > a) {
                    double area = calculateTriangleArea(a, b, c);
                    printf("The area of the triangle is: %.2f\n", area);
                } else {
                    printf("The sides do not form a valid triangle.\n");
                }
                break;
            }
            case 2: {
                char str[100];
                printf("Enter a string: ");
                getchar();
                fgets(str, sizeof(str), stdin);
                str[strcspn(str, "\n")] = '\0'; 

                if (isPalindrome(str)) {
                    printf("The string is a palindrome.\n");
                } else {
                    printf("The string is not a palindrome.\n");
                }
                break;
            }
            case 3:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 3);

    return 0;
}
