#include <stdio.h>

struct elemento {
	int A;
	char c1, c2;
} L[8] = {{0, 'a', 'a'}, {1, 'a', 'b'}, {2, 'a', 'c'}, {3, 'a', 'd'}, {4, 'b', 'a'}, {5, 'b', 'b'}, {6, 'b', 'c'}, {7, 'b', 'd'}};


struct elemento *p;
int i = 3;

int main(void) {
	p = L;		printf("p = L: %d\n", p->A); 						// Equivale a scrivere p = &L[0];
	p = &L[4];	printf("p = &L[4]: %d\n", p->A); 					// Equivale a scrivere p = L + 4;
				printf("((p++) - 1)->A): %d\n", ((p++) - 1)->A);	// L'Incremento, anche con parentesi, avviene sempre DOPO la riga.
				printf("p->A: %d\n", p->A);
				printf("L[i].A: %d\n", L[i].A);
				// printf("L[i]->A: %d\n", L[i]->A);			
				// Non valido. Dovremmo usare L[i].A o (*p).A.
}
