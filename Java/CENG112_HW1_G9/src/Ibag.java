
public interface Ibag<T> {
    public boolean add(T newItem);
    public boolean isEmpty();
    public boolean isFull();
    public T removeByIndex(int index);
    public T remove();
    public T remove(T item);
    public int getItemCount();
    public int getIndexOf(T item);
    public void displayItems();
    public boolean transferTo(Ibag<T> targetBag, T item);
    public void dump();
	public int getNumberofitems();
	}
