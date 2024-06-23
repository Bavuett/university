#include <stdio.h>

int M = 5;
int N = 3;
int L = 3;

void matrix_vector_product(int rows, int columns, int MAT_A[M][N], int X[L], int Y[M*N]) {
    int index = 0; // Indice per l'array Y
    
    for (int i = 0; i < columns; i++) {
        for (int j = 0; j < rows; j++) {
			printf("%d ", MAT_A[j][i]);
			Y[index] = MAT_A[j][i] * X[i];// Calcola e memorizza il prodotto
			printf("(%d - * %d) ", Y[index], X[i]);
			index++;                       // Incrementa l'indice per Y
        }

	printf("\n");
    }
}

int main(void) {
	int MAT_A[5][3] = {
		{5, 2, 3},
		{6, 1, 3},
		{1, 1, 1},
		{2, 5, 9},
		{4, 6, 7}
	};

	int X[3] = {1, 5, 3};
	
	int Y[M*N];

	matrix_vector_product(M, N, MAT_A, X, Y);

	for (int i = 0; i < M*N; i++) {
		printf("%d ", Y[i]);
	};
}

