; Dopo aver scritto il programma C99, traducilo in ASM MC68000, usando
; • parole in formato long per memorizzare le variabili puntatore
; • parole in formato long per memorizzare le variabili di tipo int
; • parole in formato word per memorizzare le variabili di tipo short
; • parole in formato byte per memorizzare le variabili di tipo unsigned char

; NON TENGO TROPPO CONTO DELL'EFFICIENZA: MOLTE ESPRESSIONI POSSONO
; ESSERE TRADOTTE CON MENO RIGHE. PREFERISCO ESSERE CHIARO.

org $1000

; Il programma dichiara le seguenti variabili esterne

; • tipo int: a inizializzata a 7, b inizializzata a -5
; • tipo puntatore a int: p_si
a: dc.l 7
b: dc.l -5

p_si: dc.l 0

; • tipo short: g, h, k inizializzata a 43
; • tipo puntatore a short: p1_ss, p2_ss inizializzata con puntatore a g
g: dc.w 0
h: dc.w 0
k: dc.w 43

p1_ss: dc.l 0
p2_ss: dc.l g

; • tipo unsigned char: x, y inizializzata a 31, z inizializzata a 99
; • tipo puntatore a unsigned char: p1_uc, p2_uc
x: dc.b 0
y: dc.b 31
z: dc.b 99

p1_uc: dc.l 0
p2_uc: dc.l 0

org $2000

main:
    ; 1. p_si assume puntatore a b
    lea b, A0
    move.l A0, p_si

    ; 2. incrementa di 1 la variabile puntata da p_si
    move.l p_si, A0
    add.l #1, (A0)   

    ; 3. a assume a diminuito della variabile puntata da p_si
    move.l p_si, A0
    move.l a, D0
    sub.l (A0), D0
    move.l D0, a

    ; 4. p1_ss assume puntatore a k
    lea k, A0
    move.l A0, p1_ss

    ; 5. la variabile puntata da p2_ss assume il valore della variabile puntata da p1_ss
    move.l p1_ss, A0
    move.l p2_ss, A1
    move.w (A0), D0
    move.w D0, (A1)

    ; 6. p1_ss assume puntatore a h
    lea h, A0
    move.l A0, p1_ss

    ; 7. la variabile puntata da p1_ss assume k diminuito di 3
    move.l p1_ss, A0
    move.w k, D0
    sub.w #3, D0
    move.w D0, (A0)
    
    ; 8. p1_uc assume puntatore a x, p2_uc assume puntatore a y
    lea x, A0
    lea y, A1
    move.l A0, p1_uc
    move.l A1, p2_uc

    ; 9. la variabile puntata da p2_uc viene aumentata di 4
    move.l p2_uc, A0
    move.b (A0), D0
    add.b #4, D0
    move.b D0, (A0)

    ; 10. la variabile puntata da p1_uc assume z aumentato di 1
    move.l p1_uc, A0
    move.b z, D0
    add.b #1, D0
    move.b D0, (A0)

    ; 11. p2_uc assume il puntatore contenuto in p1_uc
    move.l p1_uc, p2_uc

    ; 12. la variabile puntata da p1_uc viene diminuita di y
    move.l p1_uc, A0
    move.b (A0), D0
    move.b y, D1
    sub.b D0, D1
    move.b D1, (A0)

    ; 13. la variabile puntata da p2_uc viene aumentata di 5
    move.l p2_uc, A0
    move.b (A0), D0
    add.b #5, D0
    move.b D0, (A0)

end: