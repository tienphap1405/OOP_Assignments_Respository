package implementations;

/**
 * Represent the node which links to the next and previous nodes and
 * it would be utilized in double linked list data structure
 * @author Simon Luna Patiarroy, Tien Phap (Evan) Nguyen
 * @param <E> element type of the nodes in the double linked list
 */
public class MyDLLNode<E>
{

    private E element;
    private MyDLLNode<E> next = null;
    private MyDLLNode<E> prev = null;

    /**
     * the constructor to create a node for the double linked list
     * @param element the value or data that in the node
     */
    public MyDLLNode(E element){
        this.element = element;
    }

    /**
     * return the data of the node
     * @return the data of the node
     */
    public E getElement() {
        return element;
    }

    /**
     *  update the data of the node
     * @param element new data that will be stored in this node
     */
    public void setElement(E element) {
        this.element = element;
    }  

    /**
     * return the next node in the linked list
     * return the address of t of the current node 
     * @return
     */
    public MyDLLNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     * @param next the node that should follow this node in the list
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the linked list.
     * @return the previous node in the list
     */
    public MyDLLNode<E> getPrev() {
        return prev;
    }
    
    /**
     * Sets the previous node in the linked list.
     * @param prev the node that should precede this node in the list
     */
    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
        

}
