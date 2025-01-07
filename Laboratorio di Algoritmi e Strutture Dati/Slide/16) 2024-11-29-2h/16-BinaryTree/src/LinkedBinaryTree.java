import java.util.*;


public class LinkedBinaryTree<E> implements BinaryTree<E>, Iterable<E> {

	private Node<E> root;
	private int size;
	

	/**************** CLASS NODE ****************/
	
	private static class Node<E> {

		private Node<E> left, right, parent;	// children can be null
		private E data;

		/** Constructs a singleton root node where left, right and up are null **/
		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	 

		/** Constructs a root inner node **/
		public Node(Node<E> left, E data, Node<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = null;
			if (this.left != null) this.left.parent = this; 
			if (this.right != null) this.right.parent = this;
		}

		private void setLeft(Node<E> left) {
			this.left = left;
			if (left != null) this.left.parent = this;
		}

		private void setRight(Node<E> right) {
			this.right = right;
			if (right != null) this.right.parent = this;
		}
		
		/**
		 * @return true if the binary trees rooted at these nodes 
	     * have the same structure and contain the same values,
	     * false otherwise. 
	     * @Override
		 */
		public boolean equals(Object other) {
			Node<?> t2;
			if (other == null) return false;
			if (!(other instanceof Node<?>)) return false;
			else t2 = (Node<?>) other;
			if (!data.equals(t2.data)  ||  
				(left != null  &&  t2.left == null) || (left == null  &&  t2.left != null) ||
				(right != null  &&  t2.right == null) || (right == null  &&  t2.right != null))
				return false;
			if (left != null && !left.equals(t2.left)) return false;
			if (right!= null && !right.equals(t2.right)) return false;
			return true;
		}
						
		/**
	     * @return the size of the subtree rooted at this node,
	     * that is the number of non-null descendants of this node, plus one.
	     */
		private int size() {  //this node cannot be empty
			int lsize = 0, rsize = 0;
			if ( left !=null ) lsize = left.size();  
			if ( right !=null ) rsize = right.size();
	      		return 1 + lsize + rsize;
		}  // method size
	   	
	   	
	}  //end class Node
	
	/**************** END CLASS NODE ****************/
	

	/**
    * @return an empty binary tree.
    */
    public LinkedBinaryTree( )
    {
    	root =  null;
    	size = 0;
    } // constructor LinkedBinaryTree

 
    /**
    * @return a binary tree with the specified element as its root.
    */
   	public LinkedBinaryTree (E element) 
   	{
      	size = 1;
      	root = new Node<E> (element);
   	}  // constructor LinkedBinaryTree


   	/**
    * @return a binary tree from the two specified binary trees.
    */
   	public LinkedBinaryTree (LinkedBinaryTree<E> leftSubtree, E element, LinkedBinaryTree<E> rightSubtree) 
   	{
   		root = new Node<E> (leftSubtree.root, element, rightSubtree.root);
   		size = 1 + leftSubtree.size + rightSubtree.size; 
	}  // constructor LinkedBinaryTree 
   	     	

	/**
    * @return the number of elements in the binary tree.
    */
	public int size() 
	{
	      return size;
	}  // method size
	
	
   	/**
    * @return true if the binary tree is empty and false otherwise.
    */
    public boolean isEmpty( )
    {
    	return root == null;  // size == 0;
	}  // method isEmpty
    
		    
	/**
	* @return a reference to the element if it is found
    * in the root, null otherwise.
    */
 	public E getRoot()
 	{
 		if ( isEmpty() ) return null;
 		else return root.data;
 	}	

    /**
     *  Removes all elements from the binary tree.
     *
     */
     public void clear() {
     	root =  null;
     	size = 0;
     }
     
     
 	/**
     * @return the left subtree detached from this binary tree if not null, 
     * null otherwise.
     */
    public LinkedBinaryTree<E> removeLeft() 
    {
    	LinkedBinaryTree<E> lbtree = null;
    	if (root.left != null)  {
    		lbtree = new LinkedBinaryTree<E>();
    		lbtree.root = root.left;
    		lbtree.root.parent = null;
    		root.left = null;
    		lbtree.size = lbtree.root.size();  // costo lineare 
    		size = size - lbtree.size;		
    	}
       	return lbtree; 
    }  // method removeLeft


 	/**
     * @return the right subtree detached from this binary tree if not null, 
     * null otherwise.
     */

    public LinkedBinaryTree<E> removeRight() 
    {
    	LinkedBinaryTree<E> rbtree = null;
    	if (root.right != null)  {
    		rbtree = new LinkedBinaryTree<E>();
    		rbtree.root = root.right;
    		rbtree.root.parent = null;
    		root.right = null;
    		rbtree.size = rbtree.root.size();  // costo lineare 
    		size = size - rbtree.size;		
    	}
       	return rbtree; 
    }  // method removeRight
    
    
	/**
	 * @return a reference to the specified node containing the target element if it is found
	 * in the binary tree, null otherwise.
	 */	
	protected Node<E> find(E targetElement, Node<E> root) {
		if (root == null) return null;
		if (root.data.equals(targetElement)) return root;
		Node<E> resNode = find(targetElement, root.left);
		if (resNode == null) resNode = find(targetElement, root.right);
		return resNode;
	} // method find
	
	
	/* Removes the first occurrence of the specified
	 * element from this binary tree, if it is present.
	 * The data of the retrieved binary node is set to null. 
	 */
	public boolean remove(E targetElement) {
		if (targetElement == null) return false;
		Node<E> temp = find(targetElement, root);
		if (temp != null) {
			temp.data = null;
			return true;
		} else return false;
	}


     /**
      * @return true if the tree contains an element that matches the
      * specified target element and false otherwise.
      */
  	public boolean contains (E targetElement) 
     	{
  		if (find(targetElement, root) != null) return true;
  		else return false;
     	}  // method contains
   	

   	/**
	 * Performs a preorder traversal on the binary tree by calling
	 * a recursive preorder method that starts with the root.
     */
	public Iterator<E> iteratorPreOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	preorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorPreOrder


   	/**
	 * Performs a recursive preorder traversal.
     */
	protected void preorder (Node<E> node, List<E> templist) 
   	{
		if (node != null) 
		{
			if (node.data != null) templist.add(node.data);
			preorder (node.left, templist);
			preorder (node.right, templist);
      	}//if
	}  // method preorder


   	/**
   	 * Performs an inorder traversal on the binary tree by calling
	 * a recursive inorder method that starts with the root.
	 */
	public Iterator<E> iteratorInOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	inorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorInOrder


   	/**
   	 * Performs a recursive inorder traversal.
     */
	protected void inorder (Node<E> node, List<E> templist) 
   	{
	if (node != null) 
 	{
         inorder (node.left, templist);
         if (node.data != null) templist.add(node.data);
         inorder (node.right, templist);
      	}//if

	}  // method inorder

	

   	/**
   	 * Performs a postorder traversal on the binary tree by calling
   	 * a recursive postorder method that starts with the root.
     */
	public Iterator<E> iteratorPostOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	postorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorPostOrder


   	/**
   	 * Performs a recursive postorder traversal.
     */
	protected void postorder (Node<E> node, List<E> templist) 
   	{
		if (node != null) 
		{
			postorder (node.left, templist);
			postorder (node.right, templist);
			if (node.data != null) templist.add(node.data);
      	}//if
	}  // method postorder 

	
   	/**
   	 * Performs a levelorder traversal on the binary tree using a templist
     */
	public Iterator<E> iteratorLevelOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();  // non   l'array posizionale!
      	levelorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorLevelOrder


   	/**
   	 * Performs an iterative levelorder traversal.
     */
   	protected void levelorder(Node<E> node, List<E> templist) 
   	{
   		Queue<Node<E>> queueOfnodes = new LinkedList<Node<E>>();  
      	Node<E> current;
      	queueOfnodes.offer (node);
      	while (! queueOfnodes.isEmpty()) {
	         current = queueOfnodes.remove();
	         if (current.data != null) templist.add(current.data);
	         if (current.left != null)  queueOfnodes.offer (current.left);
	         if (current.right != null) queueOfnodes.offer (current.right);
      	}//while
    }  // method levelorder 
   	
   	
   	
	public Iterator<E> iterator() 
   	{ 	
		return iteratorPreOrder();
		//return iteratorInOrder(); 
		//return iteratorPostOrder(); 
		//return iteratorLevelOrder();
   	}

    
   	/**
	  * Performs an iterative preorder traversal on the binary tree using a templist
      */

	public Iterator<E> iteratorItPreorder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	itpreorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorItPreorder


   	/**
	  * Performs an iterative preorder traversal.
      */
   	protected void itpreorder(Node<E> node, List<E> templist) 
   	{

   		Stack<Node<E>> stackOfNodes = new Stack<Node<E>>();  // stack of nodes
      	Node<E> current;

      	stackOfNodes.push(node);

      	while (! stackOfNodes.isEmpty()) {
         current = stackOfNodes.pop();
         if (current.data != null) templist.add(current.data);
         if (current.right != null) stackOfNodes.push (current.right);
         if (current.left != null)  stackOfNodes.push(current.left);
      	}//while
        }  // method itpreorder


   	/**
	  * Performs an iterative inorder traversal on the binary tree using a templist
	  */

	public Iterator<E> iteratorItInorder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	itinorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorItInorder


   	/**
	  * Performs an iterative inorder traversal.
      */
   	protected void itinorder(Node<E> node, List<E> templist) 
   	{
   		Stack<Node<E>> stackOfNodes = new Stack<Node<E>>();
   		Stack<Boolean> flags = new Stack<Boolean>();  // stack of boolean values

      	Node<E> current;
      	boolean visit;

      	stackOfNodes.push(node);
      	flags.push(false);

      	while (!stackOfNodes.isEmpty()) 
      	{
      		current = stackOfNodes.pop();
      		visit = flags.pop();
      		if (visit) { if (current.data != null) templist.add(current.data); }
      		else {
      			if (current.right != null) {
      				stackOfNodes.push(current.right); 
      				flags.push(false);
      			}
      			stackOfNodes.push(current); flags.push(true);
      			if (current.left != null)  {
      				stackOfNodes.push(current.left);
      				flags.push(false);
      			}
      		} //end-if
      	}//end-while
       
   	}  // method itinorder 


/***************** HOMEWORK *******************************************
		public Iterator<E> iteratorItPostOrder() 
***********************************************************************/		
  	
  	
	
	
}
