/*******************************************************
 *
 *  The BinaryNode class
 *
 ********************************************************/

public class BinaryNode<E> {

	private BinaryNode<E> left, right, parent;	// children can be null
	private E data;

	/** Constructs a singleton root node where left, right and up are null **/
	public BinaryNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
 

	/** Constructs a root inner node **/
	public BinaryNode(BinaryNode<E> left, E data, BinaryNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = null;
		if (left != null) this.left.parent = this; 
		if (right != null) this.right.parent = this;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BinaryNode<E> left) {
		this.left = left;
		if (left != null) this.left.parent = this;
	}

	public void setRight(BinaryNode<E> right) {
		this.right = right;
		if (right != null) this.right.parent = this;
	}
	
	public E getData() {
		return data;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public BinaryNode<E> getRight() {
		return right;
	}
	
	public BinaryNode<E> getParent() {
		return parent;
	}
		
	
	/** Does it have a left child? **/
	public boolean hasLeft() {
		return left != null;
	}


	/** Does it have a right child? **/
	public boolean hasRight() {
		return right != null;
	}
	
	/** Is it a root node? **/
	public boolean isRoot() {
		return parent == null;
	}
	
	/** Is it a left child ? **/
	public boolean isLeftChild() {
		if (parent != null && parent.left == this) return true;
		else return false;
	}
	
	/** Is it a right child ? **/
	public boolean isRightChild() {
		if (parent != null && parent.right == this) return true;
		else return false;
	}
	
	
   	/********************************************
   	 * 				EXERCISE
   	 ******************************************/
	
	/**
     * @return the size of the subtree rooted at this node,
     * that is the number of non-null descendants of this node, plus one.
     */

   	public int size() {  //this node cannot be empty
		int lsize = 0, rsize = 0;
		if ( left !=null ) lsize = left.size();  
		if ( right !=null ) rsize = right.size();
      		return 1 + lsize + rsize;
	}  // method size
	
	
	/**
	 * @return true if the binary trees rooted at these nodes 
         * have the same structure and contain the same values,
         * false otherwise. 
	 */
	public boolean equals(Object other) {
		BinaryNode<?> t2;
		if (other == null) return false;
		if (!(other instanceof BinaryNode<?>)) return false;
		else t2 = (BinaryNode<?>) other;
		if (!data.equals(t2.data)  ||  hasLeft() != t2.hasLeft() || hasRight() != t2.hasRight())
			return false;
		if (this.left != null && !left.equals(t2.left)) return false;
		if (this.right!= null && !right.equals(t2.right)) return false;
		return true;
	}
	
	
	/**
	 * @return depth of the node in the binary tree. 
	 */
	public int depth() {
		int d = 0;
		BinaryNode<E> cur = this;
		while (cur.parent != null) {
			d++;
			cur = cur.parent;
		}
	return d;
	} 
		
	
	/**
	 * @return the height of the binary tree rooted at this node. 
	 */
	public int height() {
		if (left == null && right == null)  return 0;
		int hleft = (left == null)? 0 : left.height(); 
		int hright = (right == null)? 0 : right.height(); 		
		return 1 + Math.max(hleft, hright);	
	} 
	
		

}
