
public class Ex_BinaryNode {
	
	/**
	 * Esercizio 1  II parziale 10.01.2018 
	 * Un albero binario di interi si dice pari se tutti i nodi contengono
	 * un intero positivo pari.  Realizzare il metodo statico 
	 * public static boolean IsEvenBtree (BinaryNode<Integer> node) 
	 * che verifica se l'albero binario dato e' pari.
	 **/

	 /* soluzione ricorsiva */
	 public static boolean IsEvenBtree (BinaryNode<Integer> node) {
		 if ( node == null ) return true;
		 int s = node.getData();
		 if (s % 2 == 1) return false;
		 else return IsEvenBtree (node.getLeft()) && IsEvenBtree (node.getRight());
	 }
	 
	   	 	
	/*** EX2 I appello 2015/2016  del 27/01/2016  
	Un albero binario si dice "pieno" se tutti i nodi hanno esattamente 0 o 2 figli,
	e nessun nodo ha 1 figlio. 
	Si aggiunga alla classe BinaryNode<E> un metodo ricorsivo
	public boolean isFullBtree()   
	che verifica se l'albero binario radicato nel nodo corrente e' pieno. 
	 
		public boolean isFullBtree() {
			if (this == null || (left == null && right == null) ) return true;
			if ( left !=null && right != null) 
				return (left.isFullBtree() && right.isFullBtree());
			else return false;
		}  // method isFullBtree
	*/ 
	 
	 
	 /*** EX2 III appello 2023/2024
	  * Realizzare un metodo statico
	  * public static boolean FatherIsSum(BinaryNode<Integer> root)
	  * che, dato l albero binario radicato nel nodo radice in input,
	  * verifica se ogni nodo interno (con almeno un figlio) contiene
	  * un intero che   la somma degli interi contenuti nei nodi figli. 
	  */
	 
	 
	 public static boolean FatherIsSum(BinaryNode<Integer> root) {
		 // radice nulla o foglia
		 if (root==null || (!root.hasLeft()) && !root.hasRight()) return true;
		 // root ha almeno un figlio: assegno valore 0 come default ai figli
		 int valLeft=0, valRight=0;
		 if (root.hasLeft()) valLeft=root.getLeft().getData();
		 if (root.hasRight()) valRight=root.getRight().getData();
		 if (root.getData() == valLeft+valRight) //propriet  valida localmente
			 return FatherIsSum(root.getLeft()) && FatherIsSum(root.getRight());
		 else return false;
	 	}

public static boolean FatherIsSum2(BinaryNode<Integer> root) {
	 // radice nulla o foglia
	 if (root==null || (!root.hasLeft()) && !root.hasRight()) return true;
	 if (root.hasLeft() && !root.hasRight())
		return (root.getData()==root.getLeft().getData() && FatherIsSum2(root.getLeft()));
	 if (!root.hasLeft() && root.hasRight())
		return (root.getData()==root.getRight().getData() && FatherIsSum2(root.getRight()));	
	 return (root.getData()==root.getRight().getData()+root.getLeft().getData())
			 &&	 FatherIsSum(root.getLeft()) && FatherIsSum(root.getRight());
	}

	 
	 
/*
 * Realizzare un metodo generico statico ricorsivo
 * public static <E>boolean TwinChildren(BinaryNode<E> root)
 * che, dato in input l'albero radicato in root, restituisca TRUE se esiste almeno 
 * un nodo che ha esattamente due figli e questi figli sono uguali, FALSE altrimenti.
 * 
 */
public static <E> boolean TwinChildren(BinaryNode<E> root) {
	if (root==null || (!root.hasLeft()) && !root.hasRight()) return false;
	if (root.hasLeft() && root.hasRight() && root.getLeft().getData().equals(root.getRight().getData()))
		return true;
	else return TwinChildren(root.getLeft()) || TwinChildren(root.getRight());	
}
 

	/****************************************************************************
	 * HOMEWORK
	 * 
	Si aggiunga alla classe BinaryNode<E> un metodo ricorsivo  
	public BinaryNode<E> mirror()
	che dato il nodo corrente restituisce il suo nodo "specchio", ovvero
	il nuovo nodo deve essere radice di un albero binario che  
	immagine speculare dell'albero binario radicato nel nodo corrente: 
	ogni figlio destro di questo sottoalbero diventa sinistro e viceversa. 	   	 	
	*****************************************************************************/


	
}


