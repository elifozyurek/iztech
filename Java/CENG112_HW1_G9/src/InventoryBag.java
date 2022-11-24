

@SuppressWarnings("hiding")
public class InventoryBag<T> implements Ibag<T> {
	public T[] bag;
	private final int items=14;
	private int item_no = 0;
	
	
	public InventoryBag(){
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[items];
		this.bag = tempBag;
	}
	public Item getItem(int index) {
		return (Item) bag[index];
		
		
	}
	
	public boolean add(T newItem) {
		bag[item_no] = newItem;
		item_no++;
		return true;
		
	}



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeByIndex(int index) {
		// TODO Auto-generated method stub
		return bag[index];
	}



	@Override
	public T remove(T item) {
		// TODO Auto-generated method stub
		int indexOfitem = getIndexOf(item);
		return bag[indexOfitem];
	}



	@Override
	public int getIndexOf(T item) {
	        int where = -1;
	        boolean stillLooking = true;
	        int index = 0;
	        while ( stillLooking && ( index < items)) {
	            if (item.equals(bag[index])) {
	                stillLooking = false;
	                where = index;
	            }index++;} 
	        return where;} 
	

	@Override
	public void displayItems() {
		for(int i=0;i!=bag.length;i++) {
			System.out.println(bag[i].toString());
			}}



	@Override
	public boolean transferTo(Ibag<T> targetBag, T item) {
		@SuppressWarnings("unused")
		T thing = remove(item);
		targetBag.add(thing);
		//((Item) thing).getWeight();
		return true;
		//        ...   ...
		//      ..   ...   ..
		//      ..         ..
		//       ..  E💖C  ..
		//         ..    ..
		//           .. .. 
		//             ..
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
