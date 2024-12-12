package treedemo;

/**
 *
 * @author roman
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    
    private T value;
    private Node left;
    private Node right;
  
    public Node(T value) {
        this.value = value;
        left = right = null;
    }
    
    public T getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public boolean isLeaf() {
        return left ==null && right == null;
    }
    
    public boolean hasLeft() {
        return left != null;
    }
    
    public boolean hasRight() {
        return right != null;
    }

    @Override
    public int compareTo(Node<T> other) {
        return value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
}
