; * Exercise Text

; Si consideri il seguente programma C

; short z = -2, w = 4;
; short media3( short a, short b, short c ) {
; 	return ( a + b + c ) / 3; } 

; Si scrivano 2 versioni del programma, che soddisfino i seguenti requisiti:
; 	1	Versione ASM MC68000 in cui il tipo short viene rappresentato mediante un formato di lunghezza 16 e i dati locali di f3 (parametri, variabili locali automatiche, risultato) sono gestiti attraverso lo stack
; 	2	Versione ASM MIPS32 in cui il tipo short viene rappresentato mediante un formato di lunghezza 16 e i dati locali di f3 (parametri, variabili locali automatiche, risultato) sono gestiti attraverso lo stack

org $1000

z: dc.w -2
w: dc.w 4

org $2000

; int main( void ){
; 	z = f3( -7, 45 );
; 	w = f3( z + 71, 6 );
;   	return 0; } 

main:
    move.w #45, -(sp)   ; Prepariamo il parametro y di f3.
    move.w #-7, -(sp)   ; Prepariamo il parametro x di f3.

    bsr f3              ; Chiamiamo f3(-7, 45).

    move z, 0(sp)       ; Prendiamo il valore di ritorno di f3 e salviamolo in z.

    jmp end

; Routine f3.
;
; short f3( short x, short y ) {
; 	short r = x + y;
	
; 	r = media3( r, w + x, z - y ); 
; 	if ( r <= 20 ) return r - 3;
; 	else {
; 		short k = z + 5, t;
; 		t = media3( r + 12, w + x, k );
; 		w++;
; 		return k + t; } }
;
f3: 
    sub.l #2, sp        ; Allochiamo lo spazio per r.
    move.w 6(sp), d0    ; Salviamo y in d0.
    move.w 8(sp), d1    ; Salviamo x in d1.
    add.w d0, d1        ; Effettuiamo l'operazione x + y (d1 = d1 + d0)
    move.w d1, 0(sp)    ; Salviamo x + y in r che si trova nello Stack.

    move.w 0(sp), d0    ; Salviamo r come primo parametro di media3 (usa i registri).
    move.w 8(sp), d1    ; Salviamo x in d1. 
    add.w w, d1         ; Effettuiamo l'operazione w + x (d1 = d1 + w). x si trova in d1
    move.w z, d2        ; Salviamo z in d2.
    sub.w 6(sp), d2     ; Effettuiamo l'operazione z - y (d2 = d2 - y). y si trova in 6(sp)

    bsr media3          ; Chiamiamo media3(r, w + x, z - y)

    move.w d2, 0(sp)    ; Prendiamo il valore di ritorno di media3 e salviamolo in r.

    cmp 0(sp), 20       ; Compariamo se r > 20 per andare all'else.
    bgt if_end          ; Nel codice originale entro nel corpo dell'if se r <= 20, altrimenti nell'else.

    ; Codice if.

    sub.w #3, d2        ; Effettuiamo l'operazione r - 3 (d2 = d2 - 3). r si trova in d2, nonostante r sia in 0(sp).
    move.w d2, 6(sp)    ; Sovrascriviamo x con il valore di r per ritornare potendo deallocare r in sicurezza.
    sub.w #2, sp        ; Deallochiamo r per poter utilizzare correttamente l'Indirizzo di Ritorno in SP.

    rts
    
    if_end:

    ; Codice else.

    sub.l #4, sp        ; Allochiamo spazio per k e t (short k, t).
                        ; Abbiamo ora che r = 4(sp), x = 10(sp), y = 12(sp). Tra r e x c'è il Return Address.
    move.w z, d0        ; Salviamo w in d0.
    add.w #5, d0        ; Effettuiamo l'operazione z + 5.
    move.w d0, 2(sp)    ; Salviamo z + 5 in k. k si trova in 2(sp) perché è dichiarato prima di t.
    
    move.w 4(sp), d0    ; Prepariamo il primo parametro di media3 (r + 2) caricandolo in d0.
    add.w #12, d0       ; Effettuiamo l'operazione r + 12 (d0 = d0 + 12).
    move.w 10(sp), d1   ; Prepariamo il secondo parametro di media3 (w + x) caricandolo in d1.
    add w, d1           ; Effettuiamo l'operazione w + x (d1 = d1 + w).
    move.w 2(sp), d2    ; Prepariamo il terzo parametro di media3 (k) caricandolo in d2.

    bsr media3          ; Chiamiamo media3(r + 2, w + x, k)

    move.w d2, 0(sp)    ; Prendiamo il valore di ritorno di media3 e salviamolo in t.

    add.w #1, w         ; Effettuiamo l'operazione w++.

    move.w 2(sp), d0    ; Salviamo k in d0.
    add.w 0(sp), d0     ; Effettuiamo l'operazione k + t (d0 = d0 + 0(sp)). t si trova in 0(sp).

    move d0, 10(sp)     ; Sovrascriviamo x con d0 per poter deallocare t, k, ed r in sicurezza.

    add.w #6, sp        ; Deallochiamo t, k, r. Aggiungiamo 6 perché sono tutte word.

    rts


; Routine media3.
; Input:
; - d0 (word): a (short),
; - d1 (word): b (short),
; - d2 (word): c (short).
; Output:
; - d2 (long): return ((a + b + c) / 2) (short, ma va esteso per la divisione).
media3:
    add d0, d2
    add d1, d2
    ext.l d2
    divs #3, d2

end: