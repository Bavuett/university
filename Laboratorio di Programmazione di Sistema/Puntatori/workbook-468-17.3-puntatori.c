// Scrivere la funzione int *create_array(int n, int initial_value).
// La funzione dovrà restituire un puntatore a un vettore di int allocato dinamicamente e costituito da n elementi.
// Ogni elemento dovrà essere inizializzato al valore initial_value. Il valore restituito dovrà essere uguale a 
// NULL nel caso in cui il vettore non possa essere allocato.

#include <stdio.h>
#include <stdlib.h>

int *create_array(int n, int initial_value) {
    int* pointer_to_array = (int *)malloc(n * sizeof(int));

    if (pointer_to_array == NULL) {
        return NULL;
    }

    // Copiamo il puntatore originale in modo da lasciare intatto il puntatore al primo elemento che andrà restituito.
    int* pointer_to_array_copy = pointer_to_array;

    while (pointer_to_array_copy < pointer_to_array + n) {
        *pointer_to_array_copy = initial_value;
        pointer_to_array_copy++;
    }

    // Restituiamo il puntatore intatto per non causare Undefined Behavior.
    return pointer_to_array;
}

int main(void) {
    int N = 4;

    int* array = create_array(N, 2);

    for (int i = 0; i < N; i++) {
        printf("%d\n", *(array + i));
    }

}