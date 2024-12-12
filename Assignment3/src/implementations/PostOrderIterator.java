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
public class PostOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    private Stack<BSTreeNode<E>> stack = new Stack<>();
    private BSTreeNode<E> lastVisited = null;

    public PostOrderIterator(BSTreeNode<E> root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E next() {
        while (hasNext()) {
            BSTreeNode<E> current = stack.peek();
            if ((current.getLeft() == null && current.getRight() == null) || 
                (lastVisited != null && (lastVisited == current.getLeft() || lastVisited == current.getRight()))) {
                lastVisited = stack.pop();
                return lastVisited.getElement();
            } else {
                if (current.getRight() != null) stack.push(current.getRight());
                if (current.getLeft() != null) stack.push(current.getLeft());
            }
        }
        throw new NoSuchElementException("No element left to iterate");
    }
}   
