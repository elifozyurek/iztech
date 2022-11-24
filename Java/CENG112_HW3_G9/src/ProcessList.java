

public class ProcessList<T> implements IList<T>{

	private T[] list;
	private int numberOfItems;
	private static int DEFAULT_CAPACITY = 10;


	@SuppressWarnings("unchecked")
	public ProcessList(){
		T[] tempList = (T[]) new Object[10];
		this.list=tempList;
	}
	
	
	public void add(T newItem) {
		list[numberOfItems] = newItem;
		numberOfItems++;
	}
	
	public void addByIndex(int index,T newItem) {
		if(!isFull()) {
		if(!isEmpty()) {
			for(int index1=index;numberOfItems+1>index1;numberOfItems--) {
				list[numberOfItems] = list[numberOfItems-1];
			}
			list[index] = newItem;	}
		else {
			list[0] = newItem;
			numberOfItems++;}}
	}
	


	
	public T remove(int index) {
		if(!isEmpty() && index<numberOfItems) {
        T a = list[index];
        for(int q=index;q<numberOfItems-1;q++) {
        	list[q]=list[q+1];
        	
        }
        list[numberOfItems-1]=null;
        numberOfItems--;
		return a;
		}
		
		else {
			throw new IndexOutOfBoundsException();
		}}
	
	
	public int getItemCount() 
	{return numberOfItems;}
	
	
	public T getItem(int index) {
		if(index>numberOfItems) {
			throw new IndexOutOfBoundsException();}
		else {
	        T a = list[index];
			return a;}}
		
	public boolean isFull() {
		return DEFAULT_CAPACITY ==numberOfItems;}	
	
	public boolean isEmpty() {
		return numberOfItems==0;}

}
