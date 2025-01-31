public class BinaryNode {
    public int element;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int element) {
        this.element = element;
    }

    public static boolean verifySumProperty(BinaryNode node) {
        if (node == null) return true;

        int left_node_element = node.left != null ? node.left.element : 0;
        int right_node_element = node.right != null ? node.right.element : 0;

        if ((left_node_element + right_node_element) != node.element) return false;
        
        return (verifySumProperty(node.left) && verifySumProperty(node.right));
    }
}