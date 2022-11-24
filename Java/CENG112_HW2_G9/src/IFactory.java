
public interface IFactory<T> {
	boolean enqueue(T newProduct);
	void display();
	T getFront();
	void dequeue();
	boolean isEmpty();
	void clear();
	
}
