/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.Stack;
import utilities.Iterator;

/**
 *
 * @author tienp
 */
public class PreOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    private Stack<BSTreeNode<E>> stack = new Stack<>();
    
    public PreOrderIterator(BSTreeNode<E> root) {
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
        if (!hasNext()) {
            return null;
        }
        BSTreeNode<E> node = stack.pop();
        E result = node.getElement();
        if (node.hasRight()) {
            stack.push(node.getRight());
        }
        if (node.hasLeft()) {
            stack.push(node.getLeft());
        }
        return result;
    }    
}
