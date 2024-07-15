; #include <stdio.h>
; #define N 10
; unsigned char array1[8] = {9, 3, 0, 5, 1, 12, 19, 7};
; long int array2[N] = {-5, 27, -39, -9, -58, 3, -67, -2, 4, 9};
; int s = 0;

; int main(void) {
;     for (int i = 0; i < 8; i++) {
;         array1[i] += 6;
;     }
;     for (int i = 0; i < N; i++) {
;         s += array2[i];
;     }
;     for (int i = N - 1; i >= 0; i--) {
;         if (s / N > array2[i]) {
;             printf("%ld ", array2[i]);
;         }
;     }
;     printf("\n");
;     return 0;
; }

; Traduci il seguente programma C99 in ASM MC68000, usando
; • parole in formato long per memorizzare le variabili di tipo long
; • parole in formato byte per memorizzare le variabili di tipo unsigned char
; • indirizzamenti indiretto-registro con modifica automatica per accedere in modo efficiente agli elementi
; degli array

org $1000

array1: 
    dc.b 9, 3, 0, 5, 1, 12, 19, 7

array2: 
    dc.l -5, 27, -39, -9, -58, 3, -67, -2, 4, 9

s: 
    dc.l 0

org $2000

main: 
    ; for (int i = 0; i < 8; i++) {
    ;   array1[i] += 6;
    ; }
    move.l #0, d7       ; Carichiamo il Valore Immediato 0 in d7 per utilizzarlo come contatore.
    lea array1, a0      ; Carichiamo l'Indirizzo Effettivo di array1 in a0.

    for1_beg:
    cmp #7, d7          ; Compariamo il Valore Immediato 7 con il d7.
    bgt for1_end        ; Se d7 è più grande di 7, saltiamo alla conclusione del Ciclo For.

    move.b (a0), d0     ; Carichiamo il Valore Contenuto in array1[i] in d0. 
    add.b #6, d0        ; Effettuiamo l'Operazione array1[i] += 6 (d0 = 6 + d0).

    move.b d0, (a0)     ; Carichiamo il Risultato dell'Operazione in array1[i].

    add.l #1, a0        ; Incrementiamo l'Indirizzo contenuto in a0 (1 perché byte) per fare riferimento al prossimo valore dell'Array.

    add.l #1, d7        ; Incrementiamo il contatore per tenere traccia del nostro progresso nel ciclo.
    jmp for1_beg        ; Torniamo all'inizio del ciclo for.

    for1_end:

    ; for (int i = 0; i < N; i++) {
    ;   s += array2[i];
    ; }
    move.l #0, d7       ; Carichiamo il Valore Immediato 0 in d7 per utilizzarlo come contatore.
    lea array2, a0      ; Carichiamo l'Indirizzo Effettivo di array2 in a0.
    lea s, a1           ; Carichiamo l'Indirizzo Effettivo di s in a1.

    for2_beg:
    cmp #9, d7          ; Compariamo il Valore Immediato 9 con il d7. 
    bgt for2_end        ; Se d7 è più grande di 9, saltiamo alla conclusione del Ciclo For.

    move.l (a0), d0     ; Carichiamo il Valore contenuto in array2[i] in d0.
    move.l (a1), d1     ; Carichiamo il Valore contenuto in s in d1.

    add.l d0, d1        ; Effettuiamo l'Operazione s += array2[i] (d1 = d1 + d0).

    move.l d1, (a1)     ; Carichiamo il Risultato dell'Operazione in s.

    add.l #4, a0        ; Incrementiamo l'Indirizzo contenuto in a0 (4 perché long) per fare riferimento al prossimo valore dell'Array.

    add.l #1, d7        ; Incrementiamo il contatore per tenere traccia del nostro progresso nel ciclo.
    jmp for2_beg        ; Torniamo all'inizio del ciclo for.    

    for2_end:

    ; for (int i = N - 1; i >= 0; i--) {
    ;   if (s / N > array2[i]) {
    ;       printf("%ld ", array2[i]);
    ;   }
    ; }
    move.l #9, d7       ; Carichiamo il Valore Immediato 9 (N - 1) in d7 per utilizzarlo come contatore.
    lea array2, a0      ; Carichiamo l'Indirizzo Effettivo di array2 in a0.
    lea s, a1           ; Carichiamo l'Indirizzo Effettivo di s in a1.

    add.l #40, a0       ; Incrementiamo di 40 l'Indirizzo Effettivo di array2 per fare riferimento all'ultimo valore dell'Array dall'inizio. 

    for3_beg:
    cmp #0, d7          ; Compariamo il Valore Immediato 0 con il d7.
    blt for3_end        ; Se d7 è minore di 0, saltiamo alla conclusione del Ciclo For.

    move.l (a0), d0     ; Carichiamo il Valore contenuto in array2[i] in d0.
    move.l (a1), d1     ; Carichiamo il Valore contenuto in s in d1.

    divs d0, d1       ; Effettuiamo l'Operazione s / N (d1 = d1 / d0).
    move.w d1, d2       ; Carichiamo solo il quoziente dell'Operazione in d2.

    cmp d2, d0          ; Compariamo il Valore contenuto in d0 con il Risultato dell'Operazione s / N.
    bgt if_end

    move.l (a0), d6     ; Simuliamo la stampa a schermo spostando il valore in d6.

    if_end:    

    sub.l #4, a0        ; Decrementiamo l'Indirizzo contenuto in a0 (4 perché long) per fare riferimento al prossimo valore dell'Array.

    sub.l #1, d7        ; Decrementiamo il Contatore per tenere traccia del nostro progresso nel ciclo.
    jmp for3_beg         

    for3_end:

end:
