#include<stdio.h>

void carry(int i, int j);

int main() {
	int i, j;
	int stop = 0;
	scanf("%d %d", &i, &j);
	stop = (i == 0 && j == 0) ? 1 : 0;
	while(!stop) {
		carry(i, j);
		scanf("%d %d", &i, &j);
		if(i == 0 && j == 0) {
			stop = 1;
		}
	}
	return 0;
}
void carry(int i, int j) {
	int lastDigit01 = 0,  lastDigit02 = 0;
	int sum = 0, carry = 0, count = 0;
	while(i != 0 && j != 0) {
		lastDigit01 = i%10;
		lastDigit02 = j%10;
		sum = lastDigit01 + lastDigit02 + carry;
		if(sum > 9) {
			carry = 1;
			count++;
		} else carry = 0;
		i = i/10;
		j = j/10;
	}
	if(count > 0) {
		if(count == 1) {
			printf("%d carry operation.\n", count);
		} else {
			printf("%d carry operations.\n", count);
		}
	} else {
		printf("No carry operation.\n");
	}
}