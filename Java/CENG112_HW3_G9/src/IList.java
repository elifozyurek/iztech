
public interface IList <T>{
	
	public void add(T newItem);
	
	public void addByIndex(int index,T newItem);
	
	public T remove(int index);
	
	public int getItemCount();
	
	public T getItem(int index);
	
}
