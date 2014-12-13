#include<stdio.h>

int main() {
	int T, maxVal, idx, size, n;
	scanf("%d\n", &T);
	while(T-- > 0) {
		int i;
		maxVal = 0;
		scanf("%d\n", &size);
		for(i = 0; i < size; i++) {
			scanf("%d", &n);
			if(maxVal < n) {
				maxVal = n;
				idx = i+1;
			}
		}
		printf("%d\n", idx);
	}
}