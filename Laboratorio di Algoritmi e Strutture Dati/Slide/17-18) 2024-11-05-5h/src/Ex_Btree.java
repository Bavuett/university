import java.util.*;

public class Ex_Btree {
	
	
/**
 * Esercizio 1  II parziale 10.01.2018
 * Un albero binario di interi si dice pari se tutti i nodi contengono
 * un intero positivo pari.  Realizzare il metodo statico 
 * public static boolean IsEvenBtree (BinaryTree<Integer> btree) 
 * che verifica se l'albero binario dato btree e' pari.
 **/
 
 public static boolean IsEvenBtreeIt (BinaryTree<Integer> btree) {
	boolean isEven = true;		
	if (btree.isEmpty()) return true; 
	Iterator<Integer> itr = btree.iteratorLevelOrder();		
	while (itr.hasNext() && isEven) {
		Integer x = itr.next();
		if (x==0 || x % 2 == 1 ) isEven = false;	
	}
	return isEven;
} 
 
 
 
 /****************************************************************************
 Realizzare il metodo statico
 public static Integer MaxValue(BinaryTree<Integer> btree) 
 che restituisce il riferimento all'oggetto intero piu' grande contenuto in btree
 *****************************************************************************/


public static Integer MaxValue(BinaryTree<Integer> btree) {
	Integer current, max;		

	if (btree.isEmpty()) return null; 
	Iterator<Integer> itr = btree.iteratorLevelOrder();		
	max = itr.next();
	while (itr.hasNext()) {
		current = itr.next();
		if (max.compareTo(current) < 0) max = current;	
	}
 		return max;
}  // method MaxValue



/****************************************************************************
 * II parziale 2022/2023 
 * Realizzare un metodo costruttore della classe LinkedBinaryTree<E> che
 * prende in input una lista di oggetti di tipo E e costruisce una catena
 * casuale tale che l'i-mo elemento della lista è posizionato al livello i-mo
 * della catena e ogni nodo ha probabilità 1/2 di avere un figlio sinistro/destro.
 
  
  public LinkedBinaryTree(List<E> list) {
		root =  null;
    	size = 0;
    	if (list.isEmpty()) return;  
    	
    	Iterator<E> itr = list.iterator();
    	E item = itr.next();
    	root = new Node<E>(item);
    	size++;
    	
    	Node<E> lastnode = root;
    	while (itr.hasNext()) {
    		item = itr.next();
    		// si crea il nodo
    		Node<E> nodo = new Node<E>(item);
    		// generates a random position of the new node: 0->left, 1->right
    		int random = new Random().nextInt(2);
    		if (random == 0) {
    			lastnode.setLeft(nodo);
    			lastnode = lastnode.left;
    		}
    		else {
    			lastnode.setRight(nodo);
    			lastnode = lastnode.right;
    		}
    		size++;	    		
    	}

	}

 

 public LinkedBinaryTree(List<E> list) {
	root =  null;
	size = 0;
	if (list.isEmpty()) return;  
	Iterator<E> itr = list.iterator();
	E item = itr.next();
	root = new Node<E>(item);
	size++;
	LinkedBinaryTree2(root, itr);
}

private void LinkedBinaryTree2(Node<E> lastnode, Iterator<E> itr) {
	if (!itr.hasNext()) return;
	E item = itr.next();
	// si crea il nodo
	Node<E> nodo = new Node<E>(item);
	// generates a random position of the new node: 0->left, 1->right
	int random = new Random().nextInt(2);
	if (random == 0) {
		lastnode.setLeft(nodo);
		lastnode = lastnode.left;
	}
	else {
		lastnode.setRight(nodo);
		lastnode = lastnode.right;
	}
	size++;
	LinkedBinaryTree2(lastnode, itr);
}

*/
	
/****************************************************************************
 * II parziale 2022 
 * Si aggiunga alla classe LinkedBinaryTree<E> un metodo che stampa 
 * le foglie dell'albero corrente (da sinistra verso destra) 

public void printLeafs() {
	if (this.isEmpty()) return;
	printLeafs(root);
}

public void printLeafs(Node<E> node) {
	if (node == null) return;
	if (node.left == null && node.right == null)
		System.out.println(node.data);
	else {
		printLeafs (node.left);
		printLeafs (node.right);
	}
}

*/

/**************************************************************************** 
 * Si aggiunga alla classe LinkedBinaryTree<E> un metodo che conta il numero
 * di foglie dell'albero corrente
 
  public int countLeafs() {
	if (this.isEmpty()) return 0;
	return countLeafs(root);
	}
  
  public int countLeafs(Node<E> node) {
	if (node == null) return 0;
	if (node.left == null && node.right == null)
		return 1;
	else {
		return countLeafs (node.left) + countLeafs (node.right);
	}
}

*/

/**************************************************************************** 
 * Si aggiunga alla classe LinkedBinaryTree<E> un metodo che 
 * Trasforma l'albero corrente in modo che ogni nodo interno abbia
 *  esattamente due figli: se un nodo ha un solo nodo figlio, si aggiunga 
 *  l'altro nodo figlio come copia del figlio esistente.

public void trasforma() {
	if (this.isEmpty()) return;
	trasforma(root); 
}


private void trasforma(Node<E> lastnode) {
	if (lastnode.left == null && lastnode.right == null)
		return;
	// the node has two children
	if (lastnode.left != null && lastnode.right !=null)
		{ trasforma(lastnode.left); trasforma(lastnode.right); }
	else { 
		// il nodo ha un solo figlio
		if (lastnode.left != null) {
			E x = lastnode.left.data;
			lastnode.setRight(new Node<E>(x));
			trasforma(lastnode.left);
		} else {
			E x = lastnode.right.data;
			lastnode.setLeft(new Node<E>(x));
			trasforma(lastnode.right);
		}
	}
	
}

*/

	 
}

