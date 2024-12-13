
package implementations;

import java.io.Serializable;
import utilities.BSTreeADT;
import utilities.Iterator;

/**
 * This class is the implementation of the Binary Search Tree
 *  based on the provided BSTreeADT
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * @param <E> Generic datatype must be comparable and Serializable
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E>, Serializable{
    private int height;
    private int size;
    private BSTreeNode<E> root;
    
    /**
     * Constructor of the empty Binary Search Tree 
     * 
     */
    public BSTree(){
        this.height = 0;
        this.size = 0;
        this.root = null;
    }
    
    /**
     * Constructor of the Binary Search Tree with the root
     * @param root the node represent the root of the tree
     */
    public BSTree(BSTreeNode<E> root){
        this.height = 1;
        this.size = 1;
        this.root = root;
    }
    
    /**
     * get the root of the binary search tree
     * @return the root node
     * @throws NullPointerException if the root is null 
     */
    @Override
    public BSTreeNode<E> getRoot() throws NullPointerException {
        if(root == null){
            throw new NullPointerException("Root is null");
        }
        return root;
    }

    /**
     * Get the height of the binary search tree
     * @return the height of the binary search tree
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Get the size or the number of nodes in the binary search tree
     * @return the size or the number of nodes in the binary search tree 
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if the binary search tree is empty or not
     * @return true if empty and false if not empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Clear, delete every nodes from the entire binary search tree 
     * by setting the size and height to 0 and the root to null
     */
    @Override
    public void clear() {
        root = null;
        height = 0;
        size = 0;
    }

    /**
     * Checks the current tree to see if the element passed in is stored in the tree.
     * @param entry the element or value that need to check
     * @return true if the element is founded in the tree, false if the element is not found in the tree
     * @throws NullPointerException if the input element is null
     */
    @Override
    public boolean contains(E entry) throws NullPointerException {
        if(entry == null){
            throw new NullPointerException("The entry is not existed or null");
        }
        BSTreeNode<E> current = root;
        while(current != null){
            if(entry.compareTo(current.getElement()) == 0){
                return true;
            }
            else if(entry.compareTo(current.getElement()) < 0){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }
        return false;
    }

    /**
     * Retrieves and return a node from the tree given the element object to search for.
     * @param entry element object being searched and need to search for
     * @return the node with that element object, return null if the node with the element object is not found
     * @throws NullPointerException if the input element object is null
     */
    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        if(entry == null){
            throw new NullPointerException("element to search is null");
        }
        BSTreeNode<E> current = root;
        while(current != null){
            if(entry.compareTo(current.getElement()) == 0){
                return current;
            }
            else if(entry.compareTo(current.getElement()) < 0){
                current = current.getLeft();
            }
            else{
                current = current.getRight();
            }
        }
        return null;
        
    }

    /**
     * Adds a new element to the tree
     * @param newEntry the element being added to the tree 
     * @return true if the element is added successfully, false if unsuccessfully
     * @throws NullPointerException if the new element passed in to add to the tree is null
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if(newEntry == null){
            throw new NullPointerException("new added element cannot be null.");
        }
        if(root == null){
            root = new BSTreeNode<>(newEntry);
            size += 1;
            height = 1;
            return true;
        }
        BSTreeNode<E> current = root;
        int currentHeight = 1;
        while(true){
            //check if the new entry is duplicated or not
            if(newEntry.compareTo(current.getElement()) == 0){
                return false; 
            }
            else if(newEntry.compareTo(current.getElement()) < 0){
                if(!current.hasLeft()){
                    current.setLeft(new BSTreeNode<>(newEntry));
                    size++;
                    height = Math.max(height, currentHeight + 1);
                    return true;
                }
                current = current.getLeft();
            }
            else{
                if(!current.hasRight()){
                    current.setRight(new BSTreeNode<>(newEntry));
                    size++;
                    height = Math.max(height, currentHeight + 1);
                    return true;
                }
                current = current.getRight();
            }
            currentHeight++;
        }
    }

    /**
     * Removes the smallest element in the tree by iterating to the leftmost of the tree
     * @return the removed element or null if the tree is empty.
     */
    @Override
    public BSTreeNode<E> removeMin() {
        if(root == null){
            return null;
        }
        BSTreeNode<E> parent = null;
        BSTreeNode<E>current = root;
        
        while(current.hasLeft()){
            parent = current;
            current = current.getLeft();
        }
        
        if(parent == null){
            root = current.getRight();
        }
        else{
            parent.setLeft(current.getRight());
        }
        size--;
        return current;
    }

    /**
     * Removes the largest element in the tree by iterating to the rightmost of the tree
     * @return the removed element or null if the tree is empty.
     */
    @Override
    public BSTreeNode<E> removeMax() {
        if(root == null){
            return null;
        }
        BSTreeNode<E> parent = null;
        BSTreeNode<E>current = root;
        
        while(current.hasRight()){
            parent = current;
            current = current.getRight();
        }
        
        if(parent == null){
            root = current.getLeft();
        }
        else{
            parent.setRight(current.getLeft());
        }
        size--;
        return current;
    }

    /**
     * Generates an in-order iteration over the contents of the tree.
     * Elements are organized in nature order.
     * @return an iterator with the elements in the natural order
     */
    @Override
    public Iterator<E> inorderIterator() {
        return new InOrderIterator<>(root);
    }

    /**
     * Generates a pre-order iteration over the contents of the tree.
     * Elements are organized in such a way as the root element is first.
     * @return an iterator with the elements in a root element first order.
     */
    @Override
    public Iterator<E> preorderIterator() {
        return new PreOrderIterator<>(root);
    }

    /**
     * Generates a post-order iteration over the contents of the tree.
     * Elements are organized in such a way as the root element is last.
     * @return an iterator with the elements in a root element last order.
     */
    @Override
    public Iterator<E> postorderIterator() {
        return new PostOrderIterator<>(root);
    }
    
}
