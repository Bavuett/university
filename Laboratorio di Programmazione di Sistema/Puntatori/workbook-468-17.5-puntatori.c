// Supponete che siano state effettuate le seguenti dichiarazioni:
// struct point {int x, y; };
// struct rectangle {struct point upper_left, lower_right};
// struct rectangle *p;
// Vogliamo che il puntatore p punti a una struttura rectangle il cui vertice
// superiore sinistro si trovi nel punto (10, 25) mentre il vertice inferiore destro si trovi
// nel punto (20, 15). Scrivete una serie di istruzioni che allochino una struttura di questo tipo
// e che la inizializzi come indicato.

#include <stdio.h>

struct point {
    int x;
    int y;
};
struct rectangle {
    struct point upper_left, lower_right;
};
struct rectangle *p;

int main(void) {
    struct rectangle ret = {
        {10, 25},
        {20, 15}
    };

    p = &ret;

    printf("Address of p: %p\n", p);
    printf("Address of ret: %p\n", &ret);

    // Accedere ad x funziona con clang ma non con gcc.
    printf("Value upper_left of Struct pointed by p: %d", (*p).upper_left.y);
}