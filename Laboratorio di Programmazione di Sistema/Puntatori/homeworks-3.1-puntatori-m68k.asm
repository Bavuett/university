; Dopo aver scritto il programma C99, traducilo in ASM MC68000, usando
; • parole in formato long per memorizzare le variabili puntatore
; • parole in formato long per memorizzare le variabili di tipo int
; • parole in formato word per memorizzare le variabili di tipo short
; • parole in formato byte per memorizzare le variabili di tipo unsigned char

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
x: dc.b 31
z: dc.b 99

p1_uc: dc.l 0
p2_uc: dc.l 0

org $2000

main:
    ; 1. p_si assume puntatore a b
    lea b, A0
    move.l A0, p_si

    ; 2. incrementa di 1 la variabile puntata da p_si
    move.l (p_si), D0
    add.l #1, D0
    move.l D0, (p_si)

