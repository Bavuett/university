.data
    r1: .word 0
    r2: .word 0
.text

start:
    sub $sp, $sp, 4     # Allochiamo spazio per una word.
    li $t0, 10          # Prepariamo il Valore Immediato 10 in t0.
    sw $t0, ($sp)       # Prepariamo il parametro x di f.
    
    jal f               # Chiamiamo f(10).

    b end

    f: 
    sw $t0, ($sp)       # Salviamo x in t0.
    blez $t0, f_return  # Branch a f_return se t0 (x) <= 0.

    div $t0, $t0, 5     # Effettuiamo l'operazione x / 5 (t0 = t0 / 5).

    sub $sp, $sp, 4     # Allochiamo spazio per una nuova word.
    sw $t0, ($sp)       # Allochiamo il risultato nello Stack per una chiamata ricorsiva.
    sw $t9, $ra         # Salviamo il Return Address in t9 per potervi ritornare in seguito.

    jal f               # Chiamiamo ricorsivamente f(x / 5).

    lw $ra, $t9         # Carichiamo il Return Address originale in RA.

    lw $t2, ($sp)       # Carichiamo il Valore Restituito in t2.
    li $t1, 110         # Carichiamo il Valore Immediato 110 in t1.
    lw $t0, 4($sp)      # Carichiamo il Valore Originale di x in t0.

    add $sp, $sp, 4     # Deallochiamo lo spazio allocato precedentemente nello Stack Pointer.

    sub $t2, $t1, $t2   # Effettuiamo l'operazione 110 - f(x/5) (t2 = t1 - t2).

    li $t3, 2           # Carichiamo il Valore Immediato 2 in t3.
    mul $t3, $t0, $t3   # Effettuiamo l'operazione 2 * x (t3 = t0  t3).
    add $t3, $t3, 1     # Effettuiamo l'operazione (2 * x) + 1.

    mul $t2, $t2, $t3   # Effettuiamo l'operazione (100 - f(x / 5)) * (2 * x + 1).

    sw $t2, ($sp)       # Carichiamo il risultato nello Stack Pointer come risultato.

    jr $ra              # Usciamo dalla funzione con lo Stack Register.


    f_return:
    li $t0, 1
    sw $t0, ($sp)

end: