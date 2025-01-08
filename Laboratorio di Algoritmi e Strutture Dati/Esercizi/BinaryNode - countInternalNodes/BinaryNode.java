public class BinaryNode<E> {
    public E element;
    public BinaryNode<E> left;
    public BinaryNode<E> right;
    
    public static <E> int countInternalNodes(BinaryNode<E> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        return 1 + countInternalNodes(root.left) + countInternalNodes(root.right);
    }
}