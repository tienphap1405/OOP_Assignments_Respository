
package implementations;

import java.util.NoSuchElementException;
import java.util.Stack;
import utilities.Iterator;

/**
 * The implementation of an post order iterator for a binary search tree.
 * This iterator traverses the BST in post-order sequence: LRV (left, right, visiting) node
 * through the entire tree
 * @author tienp
 * @param <E> The generic type of elements stored in the BST, the element must be comparable
 */
public class PostOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {
    
    /**
     * A stack to keep track of tree nodes for the post order traversal.
     */   
    private Stack<BSTreeNode<E>> stack = new Stack<>();
    /**
     * the last visited node check the where the state of the traversal when traverse through the tree.
     */   
    private BSTreeNode<E> lastVisited = null;

    /**
     * Constructor of the post order iterator with the root node
     * @param root the root node to iterate through.
     */
    public PostOrderIterator(BSTreeNode<E> root) {
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
     * Returns the next element in the post-order traversal of the BST.
     * @return The next element in the post-order traversal.
     * @throws NoSuchElementException If there are no more elements to iterate over.
     */
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
