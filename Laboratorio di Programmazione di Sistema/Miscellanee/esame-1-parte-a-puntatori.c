#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    char valore;
    struct node *succ;
} Elemento;

// Lista è un puntatore ad un elemento. Qui parte da 0, cioè NULL.
Elemento *Lista = 0;

void stampa(Elemento *L)
{ // Modifica la funzione per stampare correttamente il testo
    if (L != 0)
    {
        printf("%c", L->valore);
        stampa(L->succ);
    }
}

void inserisciFine(Elemento *L, char character)
{   
    printf("Aggiungo %c alla fine della lista. Indirizzo di L: %p\n", character, L);
    
    while (L->succ != 0)
    {
        L = L->succ;
    }

    Elemento *nuovo = (Elemento *)malloc(sizeof(Elemento));
    nuovo->valore = character;
    nuovo->succ = 0;
    
    L->succ = nuovo;

    printf("Aggiunto %c alla fine della lista. Indirizzo di Rif. Operazione: %p.\n\n", character);
}

void inserisciInizio(Elemento *L, char character) {
    printf("Aggiungo %c all'inizio della lista. Indirizzo di L: %p\n", character, L);

    Elemento *nuovo = (Elemento *)malloc(sizeof(Elemento));
    nuovo->valore = character;
    nuovo->succ = L;

    // Aggiorno il puntatore del primo elemento della lista.
    Lista = nuovo;

    printf("Aggiunto %c all'inizio della lista. Indirizzo di Rif. Operazione: %p.\n\n", character);
}

#define LEN 12

// Metodo alternativo per inizializzare gli array di caratteri
char s[LEN] = "SALVE, MONDO";

// Creo un puntatore che punta all'ultimo elemento dell'array
char *p = &s[LEN - 1];

// Creo un puntatore che punta al primo elemento dell'array
char *in = &s[0];

int main()
{   
    // Inizializza gli elementi dell'Array a partire dall'ultimo.
    // Per un esempio pratico, è come se facessimo questa dichiarazione:
    // g = {2, 0}, f = {2, &g},e = {1, &f}, d = {5, &e}, c = {4, &d}, b = {5, &c}, a = {1, &b};
    // in modo dinamico (figata!).
    for (int i = 0; i < LEN; i++)
    {
        // Crea un nuovo Elemento.
        Elemento *nuovo = (Elemento *)malloc(sizeof(Elemento));
        
        // Salva al campo "succ" di "nuovo" la posizione attuale.
        nuovo->succ = Lista;
        printf("p[-%d] (%p): %c \n", i, &p[-i], p[-i]);

        // Salva il valore della lista p nel campo "valore" di "nuovo", negando però
        // gli indici per partire dall'ultimo elemento.
        nuovo->valore = p[-i];
        Lista = nuovo;
    }

    printf("\nChiamata di funzione 1. \n");
    stampa(Lista);

    printf("\n\n");
    
    inserisciFine(Lista, '!');
    inserisciInizio(Lista, ' ');
    
    printf("\nChiamata di funzione 2. \n");
    
    stampa(Lista);
    printf("\n\n");

    printf("Stampa di stringa con While.\n");
    
    Elemento *indice; // Questa parte vi dirà come il testo va stampato
    indice = Lista;
    
    while (indice != 0)
    {
        printf("%c", indice->valore);
        indice = indice->succ;
    }

    return 0;
}
