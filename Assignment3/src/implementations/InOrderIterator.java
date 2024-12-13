package implementations;

import java.util.NoSuchElementException;
import java.util.Stack;
import utilities.Iterator;

/**
 * The implementation of an in order iterator for a binary search tree.
 * This iterator traverses the BST in in-order sequence: LVR (left, visiting, right) node
 * through the entire tree
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * @param <E> The generic type of elements stored in the BST, the element must be comparable
 */
public class InOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    /**
     * A stack to keep track of tree nodes for the in-order traversal.
     */
    private Stack<BSTreeNode<E>> stack = new Stack<>();

    /**
     * Constructs an in-order iterator with the root node.
     * @param root The root of the binary search tree to iterate over.
     */
    public InOrderIterator(BSTreeNode<E> root) {
        pushLeftSubtree(root);
    }

    /**
     * Pushes all left descendants of the given node onto the stack.
     * This ensures that the leftmost node is at the top of the stack.
     * @param node The starting node for traversing left descendants.
     */
    private void pushLeftSubtree(BSTreeNode<E> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
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
     * Returns the next element in the in-order traversal of the BST.
     * @return The next element in the in-order sequence.
     * @throws NoSuchElementException If there are no more elements to iterate over.
     */
    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator.");
        }

        BSTreeNode<E> node = stack.pop();
        E nextElement = node.getElement();

        if (node.hasRight()) {
            pushLeftSubtree(node.getRight());
        }

        return nextElement;
    }
}
