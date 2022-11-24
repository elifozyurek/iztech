
public class Factory<T> implements IFactory<T> {
	private T[] factoryQueue;
	private static int DEFAULT_CAPACITY =30; 
	private int numberOfItems=0;
	private  int head=0;
	private  int tail=0;


	public Factory() {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[DEFAULT_CAPACITY];
		factoryQueue=tempQueue;
		System.out.println("Welcome to IZTECHEA!");
	}
	
	public boolean enqueue(T newProduct) {

	        if (DEFAULT_CAPACITY == tail) {
	            System.out.println("Factory line is full!\n");	
	            return false;
	        }
	        else {
	            factoryQueue[tail] = newProduct;
	            tail++;
	            numberOfItems++;
	            return true;}     
	    }
	
	
	public void display() {
		int bedCount = 0,bookcaseCount =0,dresserCount =0,sofaCount = 0,tableCount =0,chairCount=0;	
		for(int i=0;i<tail;i++) {
			String string = factoryQueue[i].toString();

			switch (string) {
			case "Bed":
				bedCount++;
				break;
			case "Bookcase":
				bookcaseCount++;
				break;
			case "Chair":
				chairCount++;
				break;
			case "Dresser":
				
				dresserCount++;
				break;
			case "Sofa":
				sofaCount++;
				break;
			case "Table":
				tableCount++;
				break;
			}
		
		
	}
		System.out.println("\nAmount of Bed in Factory Line:" + bedCount);	
		System.out.println("Amount of Bookcase in Factory Line:" + bookcaseCount);
		System.out.println("Amount of Chair in Factory Line:" + chairCount);
		System.out.println("Amount of Dresser in Factory Line:" + dresserCount);
		System.out.println("Amount of Sofa in Factory Line:" + sofaCount);
		System.out.println("Amount of Table in Factory Line:" + tableCount);
		
		
	}
	 
	
	public  void dequeue() {

        if(head!=tail) { 
            for (int i = 0; i < tail ; i++) {
                // tail 5, 5 eleman
            	// d.c = 6
            	// 5 ten küçük olma
            	// 4. indexte 
                
                if(DEFAULT_CAPACITY-i==1) {
                	factoryQueue[i] = null;
                	break;
                }
                
                factoryQueue[i] = factoryQueue[i + 1];
            }
            if (tail < DEFAULT_CAPACITY) 
                factoryQueue[tail] = null;
            numberOfItems--;
            tail--;
        }
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
	
	
	
	
	
}


