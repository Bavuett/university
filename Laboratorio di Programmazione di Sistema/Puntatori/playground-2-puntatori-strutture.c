#include <stdio.h>

struct node {
	int A;
	struct node *succ;
} j = {4, 0}, i = {6, &j}, h = {7, &i}, g = {2, &h}, f = {3 ,&g }, e ={4, &f}, d ={2, &e}, c = {6, &d}, b = {8, &c}, a = {0, &b};

struct node *p = &a;

int main(void) {
	// Controlliamo la validità delle espressioni.
	// Espressione 1. (Non funziona alla fine).
	printf("Espressione: (p->succ)->A - Risultato: %d.\n", (p->succ)->A);	

	// Espressione 2. 
	printf("Espressione: (p->A) - Risultato: %d\n", p->A);
	
	while (p) {
		printf("Valore di A: %d - Indirizzo: %p - Prossimo: %p\n", p->A, (void *)p, (void *)p->succ);
		p = p->succ;
	}	
}

