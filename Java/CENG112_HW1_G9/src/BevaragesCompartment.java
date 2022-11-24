
public class BevaragesCompartment<T> implements Ibag<T>{
	private T[] bag;
	private int bag_capacity=0;
	private int numberOfItems=0;
	private static  int MAXIMUM_CAPACITY=4000;

	public T[] setBag(T newItem) {
		bag[this.numberOfItems] = (T)newItem;
		return bag;}
	
	public  BevaragesCompartment(){
		
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[10];
		bag=tempBag;}
	
	public boolean isFull() {
		 return bag_capacity >= MAXIMUM_CAPACITY;}
	
	public boolean add(T newItem) {
		if (this.bag_capacity+((Item) newItem).getWeight()>MAXIMUM_CAPACITY) {
			System.out.println("Bevarages Compartment is full! You wasted the"+((Item) newItem).getName()+"!!\n");
			return false; 
		}
		else {
			this.bag = setBag((T) newItem);
			this.numberOfItems++;
			this.bag_capacity+=((Item) newItem).getWeight();
			String item_name =  ((Item) newItem).getName();
			System.out.println(item_name+" added in the compartment.");
			System.out.println("Items in the comparment : "+this.numberOfItems);
			System.out.println("Current weight of Bevarages Compartment is: "+bag_capacity+"\n");
			
			return true;}
	}
		
	
	public boolean isEmpty() {
		return numberOfItems==0;}
	

	
	public T removeByIndex(int index) {
        T result = null;
        if (!isEmpty() && (index >= 0)) {
            result = bag[index];                   
            bag[index] = bag[numberOfItems - 1]; 
            bag[numberOfItems - 1] = null;       
           numberOfItems--;
         } // end if
        return result;}

	
	public T remove() {
		return null;}


	public T remove(T item) {
		int itemIndex = getIndexOf(item);
		if (itemIndex != -1){
		T thing = removeByIndex(itemIndex);
		return thing ;
		}
		else {
			return null;}}

	public int getItemCount() 
	{return numberOfItems;}

	
	public int getIndexOf(T item) {  
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while ( stillLooking && (index < numberOfItems)) {
            if (item.equals(bag[index])) {
                stillLooking = false;
                where = index;
            } 
            index++;
	       
		
	}
		return where;
	}

	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return getIndexOf(item) > -1;
	}

	public void displayItems() {
		/*
		for(int i=0;i<bag.length;i++) {
			
			
			
		}
		*/
		int remain = MAXIMUM_CAPACITY-bag_capacity;
		System.out.println("Bevarages: "+remain);
	}

	public void dump() {
		
		while(!isEmpty()) {
			remove();}}


	public boolean transferTo(Ibag<T> targetBag, T item) {
		if (getIndexOf(item) != -1) {
			@SuppressWarnings("unused")
			T thing = remove(item);
			return true;}
		else {System.out.println("The item you want not in the bag!");
		return false;}}




	@Override
	public int getNumberofitems() {
		return 0;}
		
	
	
}

