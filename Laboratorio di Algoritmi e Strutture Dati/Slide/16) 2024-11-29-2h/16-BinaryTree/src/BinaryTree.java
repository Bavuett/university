import java.util.Iterator;

/**
 * BinaryTree.java defines the interface to a binary tree data structure
 */

public interface BinaryTree<E> {


   /**
     * Should be implemented to return true if the binary tree is
     *  empty and false otherwise.
     */
   public boolean isEmpty();

   /**  
     * Should be implemented to return the number of elements in the
     *  binary tree.
     */
   public int size();
   
   
   /**
    *  Removes all elements from the binary tree.
    *
    */
    public void clear();
   
 	
 	/**
 	 * Should be implemented to return a reference to the element
 	 * if it is found in the root, null otherwise.
     */
 	public E getRoot();


    /**
     * @return true if the binary tree contains an element that matches the
     * specified target element and false otherwise.
     */
 	public boolean contains(E targetElement);   
 	   
   /**
     * Should be implemented to perform an inorder traversal on the
     * binary tree by calling an overloaded, recursive inorder method
     * that starts with the root.
     */
    public Iterator<E> iteratorInOrder();  //DFS


   /**
     * Should be implemented to perform an preorder traversal on the
     * binary tree by calling an overloaded, recursive preorder method
     * that starts with the root.
     */
    public Iterator<E> iteratorPreOrder(); //DFS

   
   /**
     * Should be implemented to perform a postorder traversal on the
     * binary tree by calling an overloaded, recursive postorder method
     * that starts with the root.
     */
    public Iterator<E> iteratorPostOrder(); //DFS

   
   /**
     * Should be implemented to perform a levelorder traversal on
     * the binary tree, using a queue.
     */
    public Iterator<E> iteratorLevelOrder(); //BFS
    
   	/**
   	 * @return a string representation of the binary tree.
     */
   	public String toString() ;
   

}  // interface BinaryTree


