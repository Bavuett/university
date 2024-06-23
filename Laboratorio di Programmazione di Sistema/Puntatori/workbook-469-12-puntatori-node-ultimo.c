// Esercizio tratto dal Libro "Programmazione in C" di Kim N. King.
//
// Scrivere la seguente funzione:
// struct node *find_last(struct node *List, int N);
// Il parametro List punta ad una lista concatenata. La funzione deve restituire un puntatore
// all'ultimo nodo contenente N. Deve restituire NULL se N non compare nella lista.

#include <stdio.h>

struct node {
    int value;
    struct node *next;
} g = {2, 0}, f = {2, &g},e = {1, &f}, d = {5, &e}, c = {4, &d}, b = {5, &c}, a = {1, &b};

struct node *find_last(struct node *List, int N) {
    struct node *LastOccurrence;

    while (List != 0) {
        if (List->value == N) {
            printf("Found an occurrence of %d at Address %p.\n", N, List);
            LastOccurrence = List;
        }

        List = List->next;
    }

    return LastOccurrence;
}

int main(void) {
    int N = 2;
    struct node *LastOccurrence = find_last(&a, N);

    printf("Last occurrence of %d is at Address %p.\n", N, LastOccurrence);
}