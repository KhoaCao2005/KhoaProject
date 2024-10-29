#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define max_size 100
int main(int argc, char *argv[]) {
	const char pw[max_size] = "password";
	const int rf = 123456789;
	//input
	do{
		int choice;
		char input_pw[max_size];
		int input_rf;
		//choice
		printf("0. Close system.\n1. Password.\n2. RF card.\n");
		printf("Please enter your choice: ");
		scanf("%d", &choice);
		getchar();
		system("cls");
		if(choice == 0) break;
		//input
		printf("\nINPUT\n");
		switch(choice){
			case 1:
				printf("Please enter password: ");
				gets(input_pw);
				break;
			case 2:
				printf("Please enter PIN: ");
				scanf("%d", &input_rf);	
				break;
			default:
				break;	
		}
		//output
		printf("\nOUTPUT\n");
		if(strcmp(pw, input_pw) == 0 || rf == input_rf){
			printf("Gate open successfully!\n");
			break;
		}else{
			printf("Incorrect rf or password, please re-enter.\n\n");
		}
	}while(1);
	printf("\nSystem close!\n");
	return 0;
}

