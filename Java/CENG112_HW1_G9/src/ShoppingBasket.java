

public class ShoppingBasket<T> implements Ibag<T> {
	
	private T[] bag;
	private  final int MAXIMUM_CAPACITY=2000;
	private int bag_capacity=0;
	public int numberOfItems;

	public int  getNumberofItems() {
		return this.numberOfItems;
	}
	


	public  ShoppingBasket() {		
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[10];
		bag=tempBag;
		numberOfItems=0;
		// TODO Auto-generated constructor stub
		}
	public T[] setBag(T newItem) {
		bag[this.numberOfItems] = (T)newItem;
		return bag;
	}
	public boolean isFull() {
		 return this.bag_capacity >= MAXIMUM_CAPACITY;}

	
	public boolean add(T newItem) {
		if (this.bag_capacity+((Item) newItem).getWeight()>MAXIMUM_CAPACITY) {
			System.out.println("There is not enough space for "+((Item) newItem).getName()+" in basket!!");
			return false;}
		else{
			this.bag = setBag((T) newItem);
			this.numberOfItems++;
			this.bag_capacity+=((Item) newItem).getWeight();
			String item_name =  ((Item) newItem).getName();
			System.out.println(item_name+" added in the basket.");
			System.out.println("Items in the basket : "+getNumberofitems());
			
			System.out.println("Current weight of basket is: "+bag_capacity+"\n");
			return true;}}
	

	public boolean isEmpty() {
		return numberOfItems==0;}
	

	public T removeByIndex(int index) {
		T result = null;
        if (!isEmpty() && (index > -1)) {
            result = this.bag[index];      
            this.bag[index] = null;
            this.bag_capacity-=((Item) result).getWeight();
            this.numberOfItems--;
        }
        return result;}

	
	public T remove(T item) {
		int indexOfitem = getIndexOf(item);
		return bag[indexOfitem];}
	public int getItemCount() 
	{return numberOfItems;}

	
	public int getIndexOf(T item) {
        int where = -1;
      
        int index = 0;
        while (true) {
            if ((item).equals((this.bag[index]))) 
            { 
                where = index;   
                break;} 
            index++;
        }
        return where;} 
	
	public void displayItems() {		
		System.out.println("Basket:");
		for(int i=0;i!=bag.length;i++) {
			if (bag[i]!=null) {
				System.out.println(bag[i].toString());	}}}

	public boolean transferTo(Ibag<T> targetBag, T item) {
			@SuppressWarnings("unused")
			T thing = remove(item);
			targetBag.add(thing);
			System.out.println("Transfer is ok.");
			return true;
	
}

	@Override
	public int getNumberofitems() {
		return this.numberOfItems;
	}



	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void dump() {
		// TODO Auto-generated method stub
		
	}
	
}

