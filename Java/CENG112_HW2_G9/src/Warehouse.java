
public class Warehouse<T> implements IWarehouse<T>{
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 20;
	private int soldCount = 0;
	
	public Warehouse() {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
		stack=tempStack;
		topIndex = -1;
	}
	
	public int getTopIndex() {
		return topIndex+1;
		
	}
	
	
	public int getSoldCount() {
		return soldCount;
	}
	
	
	public boolean isEmpty() {
        return (topIndex == -1); 
    }
	
	
	public void push(T newItem) {
		if(topIndex+1!=DEFAULT_CAPACITY) {
	        stack[topIndex + 1] = newItem;
	        topIndex++;			
		}

    }
	
    public T peek(){
        if (!isEmpty()) {
            return stack[topIndex];
        }
        else {
            return null;
        }
    }
	
    public T pop(){
        if (!isEmpty()) {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            soldCount++;
            return top;
          
        } else { 
            return null;
        }
    }

}