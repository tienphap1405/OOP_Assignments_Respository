package treedemo;

/**
 *
 * @author Simon Luna
 */
public class TreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        BST<Integer> bst = new BST<>();
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(3);
        Node<Integer> n3 = new Node<>(4);
        Node<Integer> n4 = new Node<>(2);
        Node<Integer> n5 = new Node<>(7);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(8);
        Node<Integer> n8 = new Node<>(10);
        
        bst.insert(n1);
        bst.insert(n2);
        bst.insert(n3);
        bst.insert(n4);
        bst.insert(n5);
        bst.insert(n6);
        bst.insert(n7);
        bst.insert(n8); 
        print("Done");
        
        bst.preorder(); // ?
        System.out.println("\n");
        bst.postorder(); // ?
        System.out.println("\n");
        bst.inorder(); // ?
        System.out.println("\n");
        
        print("Max and Min");
        print(bst.max()); 
        print(bst.min());
       
        
    }
    
    public static void print(Object obj) {
        System.out.println(obj);
    }
    
}
