
import java.util.Iterator;

public class OurIterator <T> implements Iterator<T>{

    private Stack<Node<T>> stack = new Stack<>();
    @SuppressWarnings("rawtypes")
	private Node current = null;

    @SuppressWarnings({ "rawtypes" })
	public  OurIterator(Node item) {
    	current=item;
    
    }
    
    
    @SuppressWarnings("rawtypes")
	public void set(T argRoot) {
    	current=(Node) argRoot;
    }


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T next() {
        while (current != null) {
            stack.push((Node<T>) current);
            current = (Node) current.left; 
            }
        
        current = (Node) stack.pop();
        if(current==null) {return null;}
        Node node = current;
        current = (Node) current.right;
        return (T) node;
        }

    public boolean hasNext() {
        return (!stack.isEmpty() || current != null);
    }


}