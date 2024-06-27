    org $1000

    r1: dc.w 0
    r2: dc.w 0

    org $2000

    main: 
        move.w #10, -(sp)   ; Prepariamo il parametro x di f.
        bsr f               ; Chiamiamo f(10).

        move.w (sp)+, r1    ; Salviamo il valore restituito in r1.

        jmp end

    f: 
        move.w 4(sp), d0    ; Salviamo x in d0. x ora si trova in 4(sp) perchè è preceduto dal Return Address.
        cmp #0, d0          ; Compariamo d0 con lo 0.
        ble f_return        ; Branch a f_return se d0 (x) <= 0.

        ext.l d0            ; Prepariamoci per la divisione, estendendo il registro a long.
        divs #5, d0         ; Effettuiamo l'operazione x / 5 (d0 = d0 / 5).

        move.w d0, -(sp)    ; Allochiamo il risultato nello Stack per preparare la chiamata ricorsiva.
        bsr f               ; Chiamiamo f(x / 5).

        move.w (sp)+, d0    ; Salviamo il risultato in d0 deallocandolo dallo Stack.
        move.w #110, d1     ; Salviamo il valore immediato 110 in d1.

        sub.w d0, d1        ; Effettuiamo l'operazione Valore di Ritorno - 100 (d1 = (sp)+ - 100).
        
        muls #2, d0         ; Effettuiamo l'operazione (2 *x) (d0 = d0 * 2).
        add.w #1, d0        ; Effettuiamo l'operazione (2 * x) + 1 (d0 = d0 + 1).

        muls d1, d0         ; Effettuiamo l'operazione ((100 - f(x/5)) - (2 * x + 1)) (d0 = d0 * d1).

        move.w d0, 4(sp)    ; Salviamo il risultato in 4(sp) prima di restituire il valore.

        rts

    f_return:
        move #1, 4(sp)      ; Sovrascriviamo x per poter restituire il risultato senza intaccare il Return Address.
        
        rts                 

    end:

