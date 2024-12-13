
package implementations;

import java.util.NoSuchElementException;
import java.util.Stack;
import utilities.Iterator;

/**
 * The implementation of an pre order iterator for a binary search tree.
 * This iterator traverses the BST in pre-order sequence: VLR (visiting, left, right) node
 * through the entire tree
 * @author tienp
 * @param <E> The generic type of elements stored in the BST, the element must be comparable
 */
public class PreOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    
    /**
     * A stack to keep track of tree nodes for the pre-order traversal.
     */
    private Stack<BSTreeNode<E>> stack = new Stack<>();
    
    /**
     * Constructor of the pre order iterator with a root node
     * @param root the root node to iterate through
     */
    public PreOrderIterator(BSTreeNode<E> root) {
        if (root != null) {
            stack.push(root);
        }
    }

    /**
     * Checks if there any more elements to traverse through in the tree
     * @return true if there are more elements to iterate,false if no elements left to iterate
     */
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Returns the next element in the pre-order traversal of the BST.
     * @return The next element in the pre-order sequence.
     * @throws NoSuchElementException If there are no more elements to iterate over.
     */
    @Override
    public E next() throws NoSuchElementException{
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator.");
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
