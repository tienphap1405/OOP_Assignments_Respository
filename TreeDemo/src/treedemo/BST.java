package treedemo;

/**
 *
 * @author roman
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
    
    private int height;
    private int size;
    private Node<T> root;
    
    public BST() {
        this.height = 0;
        this.size = 0;
        this.root = null;
    }

    public BST(Node<T> root) {
        this.height = 1;
        this.size = 1;
        this.root = root;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getRoot() {
        return root;
    }
    
    private void insert(Node<T> node, Node<T> root) {
        if (node.compareTo(root) < 0) {
            if (!root.hasLeft() ) {
                root.setLeft(node); 
            } else {
                insert(node, root.getLeft());
            }
        } else if (node.compareTo(root) > 0) {
            if (!root.hasRight() ) {
                root.setRight(node); 
            } else {
                insert(node, root.getRight());
            }
        } else {
            System.out.print("Node already exists");
        }
    }
    
    public void insert(Node<T> node) {
        if (!isEmpty()) {
            insert(node, root);
        } else {
            root = node;
        }
        
        size++;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    //VLR
    private void preorder(Node<T> root) {
        System.out.print(root.getValue() + "\t");
        if (root.hasLeft()) {
            preorder(root.getLeft());
        }
        if (root.hasRight()) {
            preorder(root.getRight());
        } 
    }
    
    public void preorder() {
        preorder(root);
    }
    
    // LRV
    private void postorder(Node<T> root) {
        
        if (root.hasLeft()) {
            postorder(root.getLeft());
        }
        if (root.hasRight()) {
            postorder(root.getRight());
        } 
        System.out.print(root.getValue() + "\t");
    }
    
    public void postorder() {
        postorder(root);
    }
    
    // LVR
    private void inorder(Node<T> root) {
        if (root.hasLeft()) {
            inorder(root.getLeft());
        }
        System.out.print(root.getValue() + "\t");
        if (root.hasRight()) {
            inorder(root.getRight());
        }        
    }
    
    public void inorder() {
        inorder(root);
    }
    
    
    private T max(Node<T> root ) {
        if (root.hasRight()) {
            return (T)max(root.getRight());
        } else {
            return root.getValue();
        }
    }
    
    public T max() {
        return max(root);
    }
    
    private T min(Node<T> root ) {
        if (root.hasLeft()) {
            return (T)min(root.getLeft());
        } else {
            return root.getValue();
        }
    }
    
    public T min() {
        return min(root);
    }
}
