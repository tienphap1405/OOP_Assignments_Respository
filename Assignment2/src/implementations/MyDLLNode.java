package implementations;

public class MyDLLNode<E>
{

    private E element;
    private MyDLLNode<E> next = null;
    private MyDLLNode<E> prev = null;

    public MyDLLNode(E element){
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }  

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }


    public MyDLLNode<E> getPrev() {
        return prev;
    }
    
    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
        

}
