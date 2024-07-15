.data
    t2: 
        .half 0
        .byte 0
        .byte 0

    t1:
        .half 0
        .byte -7
        .byte 9

    vettore:
        .byte 4, 12, 8, 0, 0, 20, 41, 0, 0
    
    c:
        .byte 0

.text

start: 
    li $t0, 5           # Carichiamo il Valore Immediato 5 in t0.
    li $t1, 2           # Carichiamo il Valore Immediato 2 in t1.
    li $t2, 6           # Carichiamo il Valore Immediato 6 in t2.

    la $s0, t2          # Carichiamo l'Indirizzo della Parola di Memoria "t2" in s0.

    sh $t0, ($s0)       # Carichiamo la half contenuta in t0 all'Indirizzo contenuto in s0.
    sb $t1, 2($s0)      # Carichiamo il byte contenuto in t1 all'Indirizzo contenuto in s0 + 2.
    sb $t2, 3($s0)      # Carichiamo il byte contenuto in t2 all'Indirizzo contenuto in s0 + 3.

    sub $sp, $sp, 8     # Allochiamo 8 byte nello Stack Pointer per memorizzare una word e una half.
    
    la $t0, vettore     # Carichiarmo l'Indirizzo della Parola di Memoria "vettore" in s0.
    li $t1, 8           # Carichiamo il Valore Immediato 8 in s1.

    sw $t0, ($sp)       # Prepariamo il parametro A di fun2.
    sh $t1, 4($sp)      # Prepariamo il parametro n di fun2.

    jal fun2

    fun2: 

    la $t0, ($sp)       # Salviamo l'Indirizzo di A in t0.
    lh $t1, 4($sp)      # Salviamo N in t1.

    add $t0, $t0, 2     # Incrementiamo l'Indirizzo contenuto in t0 per fare riferimento al campo b.

    lb $t2, ($t0)       # Salviamo il Valore contenuto all'Indirizzo contenuto in t0 in t2.

    
end:

