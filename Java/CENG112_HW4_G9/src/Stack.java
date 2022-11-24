
public class Stack<T> {
	


	private T[] stack;
	private int topIndex =-1;
	private static  int DEFAULT_CAPACITY = 20;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
		stack=tempStack;		
		
	}
	public boolean isEmpty() {
        return (topIndex == -1); 
    }
	
	public boolean isFull(){
		return topIndex==DEFAULT_CAPACITY;
	}
	
	public void push(T newItem) {
		if(isFull()) {
			enlarge();
		}
        stack[topIndex + 1] = newItem;
        topIndex++;
    }
	
    public T peek(){
        if (!isEmpty()) {
            return stack[topIndex];
        }
        else {
            return null;
        }
    }
    
    public void enlarge() {
    	DEFAULT_CAPACITY*=2;
        @SuppressWarnings({ "unchecked", "unused" })
		T[] copy = (T[]) new Object[DEFAULT_CAPACITY];

    }
	
    public T pop(){
        if (!isEmpty()) {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
          
        } else { 
            return null;
        }	
        
  
    
    }}
