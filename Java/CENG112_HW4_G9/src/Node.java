
public class Node<T>{
	
	 Node<T> left, right;
	 T middle;
	 String data;

	 /*
	@SuppressWarnings("unused")
	private  Node(Node<T> destroyDeepest,  left, Node right) {
			
		}
    */
     public Node()
     {
    	 middle = null;
         left = null;
         right = null;
     }     
     public Node(String number)
     {
    	 data = number;
    	 middle=null;
         left = null;
         right = null;
     }

     public Node(T item,String number)
     {
    	 data = number;
    	 middle= item;
         left = null;
         right = null;
     }
     
     public Node(T value) {
		// TODO Auto-generated constructor stub
	}

	public void setLeft(T n)
     {
         left = (Node<T>) n;
     }
     
     public void setRight(T n)
     {
         right = (Node<T>) n;
     }
     
  
     public T getLeft()
     {
         return (T) left;
     }
   
     public T  getRight()
     {
         return (T) right;
     }
   
     public void setData(String d)
     {
         data = d;
     }
     
     public String getData()
     {
         return data;
     }     
}
