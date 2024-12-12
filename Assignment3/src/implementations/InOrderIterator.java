/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import java.util.Stack;
import utilities.Iterator;

/**
 *
 * @author tienp
 */
public class InOrderIterator<E extends Comparable<? super E>> implements Iterator<E>{
    private Stack<BSTreeNode<E>> stack = new Stack<>();
    
    public InOrderIterator(BSTreeNode<E> root){
        pushLeftSubtree(root);
       
    }
    
    private void pushLeftSubtree(BSTreeNode<E> node){
        while(node != null){
            stack.push(node);
            node = node.getLeft();
        }
    }
    
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E next() throws NoSuchElementException {
        if(!hasNext()){
            return null;
        }
        
        BSTreeNode<E> node = stack.pop();
        E nextElement = node.getElement();
        if(node.hasRight()){
            pushLeftSubtree(node.getRight());
        }
        return nextElement;
    }
    
}
