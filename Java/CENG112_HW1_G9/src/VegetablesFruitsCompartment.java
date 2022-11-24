

public class VegetablesFruitsCompartment<T> implements Ibag<T> {
	private T[] bag;
	private int bag_capacity=0;
	private int numberOfItems=0;
	private static final int MAXIMUM_CAPACITY=3000;
		
	public  VegetablesFruitsCompartment() 
	 {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[10];
		this.bag=tempBag;
		}
	
	public T[] setBag(T newItem) {
		bag[this.numberOfItems] = (T)newItem;
		return bag;
	}
	public boolean isFull() {
		 return bag_capacity >= MAXIMUM_CAPACITY;
		}
	
	
	public boolean add(T newItem) {
		if (((Item) newItem).getWeight()+bag_capacity>MAXIMUM_CAPACITY) {
			System.out.println("Vegatables and Fruits Compartment is full! You wasted "+((Item) newItem).getName()+"!!\n");
			return false; 
		}
		else {
			this.bag = setBag((T) newItem);
			this.numberOfItems++;
			this.bag_capacity+=((Item) newItem).getWeight();
			String item_name =  ((Item) newItem).getName();
			System.out.println(item_name+" added in the compartment.");
			System.out.println("Items in the comparment : "+this.numberOfItems);
			System.out.println("Current weight of Vegatables and Fruits compartment is: "+bag_capacity+"\n");
			return true;	
		}
	}

	
	public boolean isEmpty() {
		return numberOfItems==0;}
	

	public T removeByIndex(int index) {
		T result = null;
        if (!isEmpty() && (index > -1)) {
            result = bag[index];      
            bag[index] = null;
            numberOfItems--;
        }
        return result;}


	
	public T remove() {
		return null;}


	public T remove(T item) {
		// TODO Auto-generated method stub
		int itemIndex = getIndexOf(item);
		if (itemIndex != -1){
		T thing = removeByIndex(itemIndex);
		this.bag_capacity+=((Item) thing).getWeight();
		System.out.println(this.bag_capacity);
		return thing ;
		}
		else {
			return null;
		}}

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
            }index++;}return where;}

	public boolean contains(T item) {
		return getIndexOf(item) > -1;}

	public void displayItems() {
		int remain = MAXIMUM_CAPACITY-bag_capacity;
		System.out.println("Vegetables and Fruits:"+remain);
	}



	public boolean transferTo(Ibag<T> targetBag, T item) {
		if (getIndexOf(item) != -1) {
			@SuppressWarnings("unused")
			T thing = remove(item);
			//@SuppressWarnings("unused")
			//Ibag<Item> inventoryBag = new Ibag<Item>();
			return true;}
		else {System.out.println("The item you want not in the bag!");
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
	
	}
		
	
	
}

