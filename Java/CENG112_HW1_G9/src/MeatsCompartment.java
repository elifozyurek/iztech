

public class MeatsCompartment<T> implements Ibag<T>{
	private T[] bag;
	
	private int numberOfItems=0;
	
	private int bag_capacity=0;
	
	private int MAXIMUM_CAPACITY=5000;
	
	
	public void setweight(int item_weight) {
		bag_capacity+=item_weight;
	}
	
	public  MeatsCompartment() {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[10];
		bag=tempBag;}
	
	public T[] setBag(T newItem) {
		bag[this.numberOfItems] = (T)newItem;
		return bag;
	}
	
	public void a() {
		System.out.println(5);
	}
	
	public boolean isFull() {
		// TODO Auto-generated method stub
		 return bag_capacity >= MAXIMUM_CAPACITY;
		}
	
	
	public boolean add(T newItem) {
		if (this.bag_capacity+((Item) newItem).getWeight()>MAXIMUM_CAPACITY) {
			System.out.println("Meat Compartment is full! You wasted "+((Item) newItem).getName()+"!!\n");
			return false; 
		}
		else {
		this.bag = setBag((T) newItem);
		this.numberOfItems++;
		this.bag_capacity+=((Item) newItem).getWeight();
		String item_name =  ((Item) newItem).getName();
		System.out.println(item_name+" added in the compartment.");
		System.out.println("Number of items : "+this.numberOfItems);
		System.out.println("Current weight of Meat Compartment is: "+bag_capacity+"\n");}
			return true;}
		

	public boolean isEmpty() {
		return numberOfItems==0;}
	

	public T removeByIndex(int index) {	
        T result = null;
        if (!isEmpty() && (index >= 0)) {
            result = bag[index];                   // entry to remove
            bag[index] = bag[numberOfItems - 1]; // Replace entry with last entry
            bag[numberOfItems - 1] = null;            // remove last entry
           numberOfItems--;
         } // end if
        return result;
	}

	public T remove() {
		// TODO Auto-generated method stub
		
		return null;
	}


	public T remove(T item) {
		// TODO Auto-generated method stub
		int itemIndex = getIndexOf(item);
		if (itemIndex != -1){
		T thing = removeByIndex(itemIndex);
		return thing ;
		}
		else {
			return null;
		}

	}

	
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
            } // end if
            index++;}
		return where;}

	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return getIndexOf(item) > -1;
	}

	public void displayItems() {		
	/*	for(int i=0;i!=bag.length;i++) {
			if (bag[i]!=null) {
				System.out.println(bag[i].toString());				
			}

		}
		*/
		int remain = MAXIMUM_CAPACITY-bag_capacity;
		System.out.println("Meats:"+remain);
	}



	public boolean transferTo(Ibag<T> targetBag, T item) {
		if (getIndexOf(item) != -1) {
			@SuppressWarnings("unused")
			T thing = remove(item);
			//@SuppressWarnings("unused")
			targetBag.add(thing);
			System.out.println("Transfer is ok.");
			return true;
			
		}
		else {
			System.out.println("The item you want not in the bag!");
		return false;
		}
	}


	@Override
	public int getNumberofitems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dump() {
		// TODO Auto-generated method stub
		
	}
		
	
	
}

