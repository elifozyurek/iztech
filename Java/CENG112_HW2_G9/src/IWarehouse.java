
public interface IWarehouse<T> {
	int getTopIndex();
	int getSoldCount();
	boolean isEmpty();
	void push(T newItem);
	T pop();
	T peek();
}
