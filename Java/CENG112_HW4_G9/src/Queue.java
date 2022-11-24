
public class Queue<T> {
	private T[] factoryQueue;
	private static int DEFAULT_CAPACITY =30; 
	private int numberOfItems=0;
	private  int head=0;
	private  int tail=0;


	public Queue() {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[DEFAULT_CAPACITY];
		factoryQueue=tempQueue;
	}
	
	public boolean enqueue(T newProduct) {

	        if (DEFAULT_CAPACITY == tail) {
	            System.out.println("The Queue is full! \n");	
	            return false;
	        }
	        else {
	            factoryQueue[tail] = newProduct;
	            setTail(getTail() + 1);
	            numberOfItems++;
	            return true;}     
	    }
	
	
		 
	
	public  T dequeue() {
		if(!isEmpty()) {
			numberOfItems--;
			return factoryQueue[tail-numberOfItems-1];
		}
		return null;
    }
	
	
	public T getFront() {
		return factoryQueue[0];	
		// Returns the object that in front of the queue but don't change anything.
	}	
	
	
	public boolean isEmpty() {
		return numberOfItems==0;
	}	
	
	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}
		
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}
	
	
	
	
	

}
