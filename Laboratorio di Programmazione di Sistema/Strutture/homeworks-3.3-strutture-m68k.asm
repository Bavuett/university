org $1000

; Per la traduzione in ASM MC68000 usa
; • parole in formato long per memorizzare le variabili di tipo long
; • parole in formato byte per memorizzare le variabili di tipo unsigned char
; • l’indirizzamento indiretto-registro con offset per accedere ai membri delle strutture

; struct str_type2 {
;    long size ;
;    unsigned short quantity ;
;    unsigned char k1 , k2 ;
; } dat1 = { 201000 , 400 };

; unsigned short x ;

dat1:
    dc.l 201000
    dc.w 400
    dc.b 0
    dc.b 0

; struct str_type2 dat2;
dat2:
    dc.l 0
    dc.w 0
    dc.b 0
    dc.b 0

; dat3 = { . quantity = 100 , ’Z ’ };
dat3: 
    dc.l 0
    dc.w 100
    dc.b 'Z' 
    dc.b 0

x: 
    dc.w 0

org $2000

main:
    ; scanf ( " % ld " , & dat3 . size ) ;
    lea dat3, A0
    move.l #$2004, D0
    trap #15

    move.l D1, (A0)

    ; dat1 . k2 = ’S ’;
    lea dat1, A0
    move.b #'S', 7(A0)

    ; scanf ( " % hu " , & x ) ;
    lea x, A0
    move.l #$2004, D0
    trap #15

    move.w D1, (A0)

    ; dat1 . quantity += 2 * x ;
    lea dat1, A0
    lea x, A1
    add.l #4, A0
    move.w (A0), D0
    move.w (A1), D1
    mulu #2, D1
    add.w D1, D0
    move.w D0, (A0)

    ; dat2 = dat3 ;
    lea dat2, A0 ; Cominciamo prendendo gli Indirizzi
    lea dat3, A1 ; delle rispettive variabili.

    ; Copiamo la Size (long).
    move.l (A1), D0
    move.l D0, (A0)

    ; Copiamo la Quantity (word).
    move.w 4(A1), D0 ; Carichiamo in D0 il contenuto di A1 + 4 perché Quantity dista 4 posizioni da Size (A1).
    move.w D0, 4(A0) ; Stessa logica viene applicata con dat2.

    ; Copiamo le K1 e K2 (byte).
    move.b 6(A1), D0 ; Visto che le word occupano solo 2 byte, stavolta l'offset sarà 4 (Size: long) + 2 (Quantity: word).
    move.b D0, 6(A0) ; Medesima logica viene applicata con dat2.
    move.b 7(A1), D0 ; Per copiare K2 avanzeremo di una sola posizione in quanto viene precedeuto da un byte.
    move.b D0, 7(A0)

    ; dat2 . k2 = x % 64;
    lea dat2, A0
    lea x, A1
    move.w (A1), D0
    divu #64, D0
    swap D0
    move.b D0, 7(A0)

    ; dat2 . size -= dat1 . size ;
    lea dat1, A0
    lea dat2, A1
    move.l (A1), D0
    move.l (A0), D1
    sub.l D1, D0
    move.l D0, (A1)

    ; dat2 . quantity += dat1 . quantity ;
    lea dat1, A0
    lea dat2, A1
    move.w 4(A0), D0
    move.w 4(A1), D1
    add.w D0, D1
    move.w D1, 4(A1)

    lea dat1, A0
    move.b (A0), D0  ; Carica dat1.k2 in D0
    ext.w D0           ; Estendi D0 a word (16 bit)
    move.l #2, D1       ; Codice funzione 2 per stampa carattere
    trap #15         ; Chiama la routine di sistema per stampare dat1.k2

    move.l #10, D0      ; Carica il carattere newline in D0
    move.l #2, D1       ; Codice funzione 2 per stampa carattere
    trap #15         ; Chiama la routine di sistema per stampare newline

end: