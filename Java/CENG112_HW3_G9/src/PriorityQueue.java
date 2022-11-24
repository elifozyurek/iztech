

public class PriorityQueue<T> {

	private T[] queue;	
	private final static int DEFAULT_CAPACITY = 20;
	private int head,tail,numberOfItems =0;
	
	public PriorityQueue() {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[DEFAULT_CAPACITY];
		queue=tempQueue;}
	
	public boolean add(T newEntry) {
		//We check new entry's priority and insert the entry if its priority is higher than others.
		int newEntryPriority = ((Computation) newEntry).getProcess().getPriority();
		if(!isEmpty()) {
		for(int index1 = 0;index1<numberOfItems;index1++){
		 if (newEntryPriority<((Computation) queue[index1]).getProcess().getPriority()){
			 for(int back= numberOfItems;index1<back;back--) {
			     queue[back]=queue[back-1];	
			     
			 }   
		     queue[index1] = newEntry;    
		     numberOfItems++;
		     tail++;
		     return true;} }
	     queue[numberOfItems]=newEntry; 
	     numberOfItems++;
	     tail++;
	    
		return true;
		}
		else {
		     queue[0] = newEntry;    
		     numberOfItems++;
		     return true;}}

	
	public T dequeue() {
		T itemT = queue[0];
        if(!isEmpty()) { 
            for (int i = 0; i < numberOfItems ; i++) {   
                if(DEFAULT_CAPACITY-i==1) {
                	queue[i] = null;
                	break;
                }
                queue[i] = queue[i + 1];
            }

            numberOfItems--;}
		return itemT ;}
	
	
	public T peek() {
		if(!isEmpty()) {
			return queue[head];
		}
		else {return null;}
		}

	
	public boolean isEmpty() {
		return numberOfItems==0;
		}
	
	public int getSize() {
		return DEFAULT_CAPACITY;}

	public void clear() {
		while(!isEmpty()) {
			dequeue();}
		
	}
	
	public void display() {

		String string = "Computation Queue: ";
		for(int i =0;i<numberOfItems;i++) {
			if(i==numberOfItems-1) {string+= queue[i].toString();}
			else{string+= queue[i].toString()+"ns<-";}
		}		
		System.out.println(string);

		
	}
	
}
