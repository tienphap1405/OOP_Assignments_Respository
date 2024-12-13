
package implementations;

import java.io.Serializable;

/**
 * The class indicates the implementation of Node structure of the Binary Search Tree 
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * @param <E> Generic Data type of the element object
 */
public class BSTreeNode<E extends Comparable<? super E>> implements Comparable<BSTreeNode<E>>, Serializable {
    private E element;
    private BSTreeNode left;
    private BSTreeNode right;
  
    /**
     * Constructor of a new Binary Search Tree Node with the value to passed in
     * @param value the element to store inside the node
     */
    public BSTreeNode(E element) {
        this.element = element;
        left = right = null;
    }
    
    /**
     * Retrieve and return an element stored in this node
     * @return the element stored in this node
     */
    public E getElement() {
        return element;
    }

    /**
     * Retrieve and return the left child of this node
     * @return the left child node, null if the node don't contain the left child
     */
    public BSTreeNode getLeft() {
        return left;
    }

    /**
     * Retrieve and return the right child of this node
     * @return the right child node, null if the node don't contain the right child
     */
    public BSTreeNode getRight() {
        return right;
    }

    /**
     * Set or update the element of this node
     * @param element the updated element to store in this node
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * set or update the left child of this node
     * @param left the left child node to update 
     */
    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    /**
     * set or update the right child of this node
     * @param right the right child node to update
     */
    public void setRight(BSTreeNode right) {
        this.right = right;
    }
    
    /**
     * Checks if this node is a leaf node or does it contain no left or right children. 
     * @return true if its a leaf node, false if the not a leaf node
     */
    public boolean isLeaf() {
        return left ==null && right == null;
    }
    
    /**
     * Checks if this node has a left child.
     * @return true if it has the left child, false if its not
     */
    public boolean hasLeft() {
        return left != null;
    }
    
    /**
     * Checks if this node has a right child.
     * @return true if it has the right child, false if its not
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * Compares this node with another node based on their stored elements.
     * @param other the other node that will be compared to.
     * @return zero if the element value of both the nodes are equal
     *         negative if this element of this node is less than other element of the other node
     *         positive if this element of this node is larger than other element of the other node
     */
    @Override
    public int compareTo(BSTreeNode<E> other) {
        return element.compareTo(other.element);
    }

    /**
     * Print the node with its element and its left and right child
     * @return to the console the node with its element and its left and right child
     */
    @Override
    public String toString() {
        return "Node{" + "element=" + element + ", left=" + left + ", right=" + right + '}';
    }    
}
