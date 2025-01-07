/* 
 * Genera N stringhe alfabetiche random di lunghezza massima L.
 * 
 */

import java.util.*;

public class Test_BTree {

	final static int L = 10;
	final static int N = 7;
	
	// Generazione casuale di una stringa
		public static String randomString(int length) {
			if (length == 0) return new String();
			String ssource = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz"; 
			String sout;
			char[] src = ssource.toCharArray();
			char[] buf = new char[length];
			for(int i = 0; i < length; i++)
				buf[i] = src[new Random().nextInt(src.length)];
			sout = new String(buf);
			System.out.println(sout);
			return sout;
		} 
			
	public static LinkedBinaryTree<String> buildRandomTree(int size) {
		if (size == 0) return new LinkedBinaryTree<String>();
		String [] strings = new String[size];
		int len;
		Random rand = new Random();
		for (int i=0; i<size; i++) {
			do { len = rand.nextInt(L+1); } while (len == 0);
			strings[i] = randomString(len);
		}
		return new LinkedBinaryTree<String>(strings);
	}
	
	
	 /*	public static LinkedBinaryTree<String> buildTree2(int size) {
		Random rand = new Random();
		if (size == 0) return new LinkedBinaryTree<String>();
		String element = randomString(rand.nextInt(L+1));
		while (element.isEmpty()) element = randomString(rand.nextInt(L+1));
		LinkedBinaryTree<String> leftBtree = buildTree2((size-1)/2);
		LinkedBinaryTree<String> rightBtree = buildTree2(size-1-(size-1)/2);
		return new LinkedBinaryTree<String>(leftBtree, element, rightBtree);
	} */
	 
	 
			
	public static void main (String[]args){
		LinkedBinaryTree<String> btree = buildRandomTree(N);
		
		Iterator<String> itr = btree.iteratorPreOrder();
		System.out.println("\n PREORDER"); 
		while (itr.hasNext()) System.out.println(itr.next()); 
		
		itr = btree.iteratorInOrder();
		System.out.println("\n InORDER"); 
		while (itr.hasNext()) System.out.println(itr.next()); 
		
		itr = btree.iteratorPostOrder();
		System.out.println("\n PostORDER"); 
		while (itr.hasNext()) System.out.println(itr.next()); 
		
		itr = btree.iteratorLevelOrder();
		System.out.println("\nLevelORDER"); 
		while (itr.hasNext()) System.out.println(itr.next()); 
		
		//itr = (btree.mirror()).iteratorLevelOrder();
		//System.out.println("\nLevelORDER MIRROR "); 
		//while (itr.hasNext()) System.out.println(itr.next()); 


	}

}
