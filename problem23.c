#include <stdio.h>
#include <stdlib.h>

int abundant(int *value)  {
	int i, temp_int = *value;
	float j, temp_float = (float)*value;
	int sum = 1;

	for (i = 2, j = 2; i <= (*value / 2); i++, j++) {
		if (temp_int / i == temp_float / j) {
			sum += i;
		}
	}


	if (sum > *value) {
		*value = sum;
		
		return 1;
	}
	else {
		*value = sum;
	}

	return 0;
}

int main(int argc, char **argv) {
	int i, *temp;
	int *array;
	int counter = 0;

	temp = malloc(1);
	array = malloc(atoi(argv[1]));

	for (i = 0; i < atoi(argv[1]); i++) {
		*temp = i;
		if (abundant(temp)) {
			printf("%d\n", i);
			array[counter++] = i;
		}
	}

	return 0;
}
