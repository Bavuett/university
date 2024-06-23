.data

N: .word 10
	
array1:
	.byte 9, 3, 0, 5, 1, 12, 19, 7
	
array2: 
	.word -5, 27, 39, -9, -58, 3, 67, -2, 4, 9

id1:
	.word 0

id2:
	.word 0
	
.text

main:
	# array1 [ 3 ] += 8;
	la $t1, array1
	addi $t1, $t1, 3 	# Aggiungiamo 3 perché ogni elemento è un byte e occupa uno spazio.
	lb $t2, ($t1)		# Carichiamo in t2 il valore il cui indirizzo è contenuto in t1.
	add $t2, $t2, 8		# Primo operando è la posizione di salvataggio del risultato, gli altri due sono i valori coinvolti nell'operazione.
	sb $t2, ($t1)		# Mettiamo il byte al suo posto.
	
	# scanf ( " % ld " , & id1 ) ;
	li $v0, 5 # Carichiamo nel Registro Ritorno (v) 0 il numero 5 per leggere numeri interi.
	syscall # Solleviamo l'eccezione nel programma in modo che l'OS inizi le procedure per l'Input.
	sw $v0, id1 # Memorizziamo la Word ottenuta dall'Input (posta sempre in v0) nella Word ad in Indirizzo id1.
	
	# array1 [ 5 ] = 3 * array1 [ id1 ];
	lw $t0, id1 # Carichiamo la Word dall'Indirizzo id1 e la salviamo nel Registro Temporaneo 0 (t0).
	la $t1, array1 # Carichiamo l'Indirizzo di array1 in t1 per poter calcolare l'offset.
	# sll $t0, $t0, 0 # Si dovrebbe moltiplicare (con shift logico) per adeguarsi all'offset, ma essendo un Array di byte non serve.
	add $t1, $t0, $t1 # Calcoliamo l'offset facendo l'addizione dell'Indirizzo di array1 con l'Indice id1.
	lb $t2, ($t1)
	mulu $t2, $t2, 3
	la $t1, array1
	sb $t2, 5($t1)
	
	# array2 [ 4 ] = 100 - array2 [ 6 ];
	la $t0, array2
	lw $t1, 24($t0) # L'Indice è 6, ma l'Array contiene delle Word. Quindi va moltiplicato per 4.
	li $t2, 100 # Necessario caricare 100 nel registro per rispettare l'ordine delle operazioni.
	sub $t1, $t2, $t1 # Per mantenere 100 - t1, quindi il secondo registro deve contenere per forza 100. Solo il terzo operando può essere immediato.
	sw $t1, 16($t0)
	
	# scanf ( " % ld " , & id2 ) ;
	li $v0, 5 # Carichiamo nel Registro Ritorno (v) 0 il numero 5 per leggere numeri interi.
	syscall # Solleviamo l'eccezione nel programma in modo che l'OS inizi le procedure per l'Input.
	sw $v0, id2 # Memorizziamo la Word ottenuta dall'Input (posta sempre in v0) nella Word ad in Indirizzo id2.
	
	# array2 [ id2 ] -= array2 [ 3 ];
	lw $t0, id2
	la $t1, array2
	lw $t2, 12($t1)
	mul $t0, $t0, 4 # Moltiplichiamo l'Indice ottenuto da tastiera per 4 in quanto stiamo lavorando con Word.
	add $t1, $t1, $t0 # Aggiungiamo l'Indice all'Indirizzo originale per utilizzarlo come offset.
	lw $t3, ($t1)
	sub $t3, $t3, $t2
	sw $t3, ($t1)
	
	
	
	
