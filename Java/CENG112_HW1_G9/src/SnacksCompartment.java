
public class SnacksCompartment<T> implements Ibag<T>{
	private T[] bag;
	private static  int MAXIMUM_CAPACITY=2000;
	private int bag_capacity=0;
	private int numberOfItems=0;
	
	public  SnacksCompartment() {	
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[10];
		this.bag=tempBag;}
	
	
	public T[] setBag(T newItem) {
		bag[this.numberOfItems] = (T)newItem;
		return bag;}
	
	
	public boolean add(T newItem) {
		if (this.bag_capacity+((Item) newItem).getWeight()>MAXIMUM_CAPACITY) {
			System.out.println("Snacks Compartment is full! You wasted "+((Item) newItem).getName()+"!!\n");
			return false; 
		}
		else {
			this.bag = setBag((T) newItem);
			this.numberOfItems++;
			this.bag_capacity+=((Item) newItem).getWeight();
			String item_name =  ((Item) newItem).getName();
			System.out.println(item_name+" added in the compartment.");
			System.out.println("Items in the comparment : "+this.numberOfItems);
			System.out.println("Current weight of compartment is: "+bag_capacity+"\n");
			return true;
		}
	}
	
	@Override
	public boolean isEmpty() {
		return numberOfItems==0;
	}
	
	public boolean isFull() {
		return this.bag_capacity == MAXIMUM_CAPACITY;}

	@Override
	public T removeByIndex(int index) {
		return null;}


	@Override
	public T remove(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndexOf(T item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displayItems() {
		int remain = MAXIMUM_CAPACITY-bag_capacity;
		System.out.println("Snacks:"+remain);
	}


	@Override
	public boolean transferTo(Ibag<T> targetBag, T item) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void dump() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getNumberofitems() {
		// TODO Auto-generated method stub
		return 0;
	}

}
