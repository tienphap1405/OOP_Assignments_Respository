/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

/**
 *
 * @author tienp
 */
public class BSTreeNode<E extends Comparable<? super E>> implements Comparable<BSTreeNode<E>> {
    private E element;
    private BSTreeNode left;
    private BSTreeNode right;
  
    public BSTreeNode(E value) {
        this.element = value;
        left = right = null;
    }
    
    public E getElement() {
        return element;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public void setRight(BSTreeNode right) {
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
    public int compareTo(BSTreeNode<E> other) {
        return element.compareTo(other.element);
    }

    @Override
    public String toString() {
        return "Node{" + "element=" + element + ", left=" + left + ", right=" + right + '}';
    }    
}
