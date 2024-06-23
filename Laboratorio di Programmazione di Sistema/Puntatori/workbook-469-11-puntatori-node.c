// Esercizio tratto dal Libro "Programmazione in C" di Kim N. King.
//
// Scrivere la seguente funzione:
// int count_occurrences(struct node *List, int N);
// Il parametro List punta a una lista concatenata, la funzione deve restituire il numero
// di volte in cui N compare nella lista. Assumete che la struttura node sia quella definita nella 
// Sezione 17.5 del libro.

#include <stdio.h>

struct node {
    int value;
    struct node *next;
} g = {9, 0}, f = {5, &g},e = {1, &f}, d = {3, &e}, c = {1, &d}, b = {5, &c}, a = {3, &b};

int count_occurrences(struct node *List, int N) {
    int counter = 0;

    while (List != 0) {
        printf("Checking value %d stored at address %p against %d.\n", List->value, List, N);
        if (N == List->value) {
            counter++;
        }

        List = List->next;
    }

    return counter;
};

int main(void) {
    struct node *List = &a;

    printf("Occurences: %d.", count_occurrences(List, 3));
}