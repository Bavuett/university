; Traduci in Assembly a SCELTA tra MC68000 
; e MIPS32 il seguente programma C, elencato nel seguito.

; **Indicazioni:**

; Le variabili di tipo `short` e `unsigned short` devono essere rappresentate da parole di un formato di lunghezza 16.
; Le variabili di tipo `long` devono essere rappresentate da parole di un formato di lunghezza 32.
; La lettura da input di un dato di tipo `unsigned short` deve essere tradotta mediante una lettura
; del contenuto della parola (magica) di lunghezza 16 che ha indirizzo `0xBA00`.
; La lettura da input di un dato di tipo `short` deve essere tradotta mediante una lettura del contenuto 
; della parola (magica) di lunghezza 16 che ha indirizzo `0xBA02`.
; La lettura da input di un dato di tipo `long` deve essere tradotta mediante una lettura del contenuto 
; della parola (magica) di lunghezza 32 che ha indirizzo `0xBA04`.

; #include <stdio.h>

; unsigned short v3 = 27, v2;

; short v1;
; long res1, res2;

; unsigned short leaf (unsigned short x1, unsigned short x2) {
;     unsigned short v1;
;     if (x2 > x1) {
;         v1 = x1;
;         x1 = x2;
;         x2 = v1;
;     }
;     return x1 + x2;
; }

; long blatt (long a) {
;     static short v2 = -48;
;     short v3 = a & 0xff;
;     v1 = (v2 + v3) - 9;
;     v3 = v2 - 32;
;     return (v3 + v1 - a);
; }

; long fun03 (unsigned short a, unsigned short b, short d) {
;     static unsigned short v1 = 30;
;     unsigned short v2 = b + 10;
;     long v3;

;     v3 = blatt (19 * d);
;     if ( (v2 + v1) < leaf ((b - 20), a)) {
;         v3 += d;
;         v1 -= d - 13;
;     }
;     return v3;
; }

; int main(void) {
;     scanf("%hu%hu%hd", &v3, &v2, &v1);
;     res1 = 200000 + fun03 (v3 - 2, 10, (v1 + 3));
;     v3 = 25 + v2;
;     res2 = blatt (res1) + fun03(v2 - 2, v3, v1);
;     printf("%ld\n%ld\n", res1, res2);
;     return 0;
; }

org $1000

v3: 
    dc.w 27
v2: 
    dc.w 0
v1: 
    dc.w 0

res1: 
    dc.l 0
res2: 
    dc.l 0

org $2000

main: 
    lea v3, a0
    lea v2, a1
    lea v1, a2

    


end: