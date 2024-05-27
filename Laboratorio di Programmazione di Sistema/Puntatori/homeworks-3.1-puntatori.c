#include <stdio.h>

//Scrivi un programma in C99 in base alla seguente specifica.
// Il programma dichiara le seguenti variabili esterne
// • tipo int: a inizializzata a 7, b inizializzata a -5
// • tipo puntatore a int: p_si
// • tipo short: g, h, k inizializzata a 43
// • tipo puntatore a short: p1_ss, p2_ss inizializzata con puntatore a g
// • tipo unsigned char: x, y inizializzata a 31, z inizializzata a 99
// • tipo puntatore a unsigned char: p1_uc, p2_uc

int a = 7, b = -5, *p_si;

short g, h, k = 43, *p1_ss, *p2_ss = &g;

unsigned char x, y = 31, z = 99, *p1_uc, *p2_uc;

// Il programma contiene un’unica funzione: main, con tipo di risultato int e lista di parametri void. La funzione
// contiene istruzioni che effettuano la seguente una sequenza di operazioni

int main(void) {
    // 1. p_si assume puntatore a b
    p_si = &b;
    
    printf("b puntato da p_si: %d\n", (*p_si));

    // 2. incrementa di 1 la variabile puntata da p_si
    (*p_si)++;

    printf("b puntato da p_si: %d\n", (*p_si));
    printf("a: %d\n", a);

    // 3. a assume a diminuito della variabile puntata da p_si
    a = a - (*p_si);

    printf("a: %d\n", a);

    // 4. p1_ss assume puntatore a k
    p1_ss = &k;

    printf("valore puntato da p2_ss: %d\n", *p2_ss);
    printf("valore puntato da p1_ss: %d\n", *p1_ss);

    // 5. la variabile puntata da p2_ss assume il valore della variabile puntata da p1_ss
    *p2_ss = *p1_ss;

    printf("valore puntato da p2_ss: %d\n", *p2_ss);

    // 6. p1_ss assume puntatore a h
    p1_ss = &h;

    printf("h: %d\n", h);
    printf("p1_ss punta a: %d\n", *p1_ss);

    // 7. la variabile puntata da p1_ss assume k diminuito di 3
    *p1_ss = k - 3;

    printf("k: %d\n", k);
    printf("p1_ss punta a: %d\n", *p1_ss);
    
    // 8. p1_uc assume puntatore a x, p2_uc assume puntatore a y
    p1_uc = &x, p2_uc = &y;

    // 9. la variabile puntata da p2_uc viene aumentata di 4
    *p2_uc = *p2_uc + 4;
    
    // 10. la variabile puntata da p1_uc assume z aumentato di 1
    *p1_uc = z + 1;

    // 11. p2_uc assume il puntatore contenuto in p1_uc
    p2_uc = p1_uc;

    // 12. la variabile puntata da p1_uc viene diminuita di y
    *p1_uc = *p1_uc - y;

    // 13. la variabile puntata da p2_uc viene aumentata di 5
    *p2_uc = *p2_uc + 5;

    return 0;
}