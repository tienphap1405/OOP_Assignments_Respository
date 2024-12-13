/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.io.Serializable;
import utilities.BSTreeADT;
import utilities.Iterator;

/**
 *
 * @author tienp
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E>, Serializable{
    private int height;
    private int size;
    private BSTreeNode<E> root;
    
    public BSTree(){
        this.height = 0;
        this.size = 0;
        this.root = null;
    }
    
    public BSTree(BSTreeNode<E> root){
        this.height = 1;
        this.size = 1;
        this.root = root;
    }
    
    @Override
    public BSTreeNode<E> getRoot() throws NullPointerException {
        if(root == null){
            throw new NullPointerException("Root is null");
        }
        return root;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
        height = 0;
        size = 0;
    }

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

    @Override
    public Iterator<E> inorderIterator() {
        return new InOrderIterator<>(root);
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreOrderIterator<>(root);
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostOrderIterator<>(root);
    }
    
}
