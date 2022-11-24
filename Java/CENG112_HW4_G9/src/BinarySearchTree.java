import java.util.*;


public class BinarySearchTree<T> {

	
	private Iterator<T> iterator;
	private Node<T> rootNode;
	private Comparator<T> comparator;
	private int numberOfItems=0; 
	private Stack<T> printStack = new Stack<>();
	private Queue<T> printQueue = new Queue<>();
	
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(Node<T> item) {
		super();
		setRootNode(item) ;
	}
	
	public BinarySearchTree(T value) {
		super();
		setRootNode(new Node<T>(value));
	}	
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Node<T> getMinimal() {
    	iterator = new OurIterator<>(getRootNode());
    	iterator = (Iterator<T>) iterator;
		Stack<Node<T>> stack = new Stack<>();

    	while(iterator.hasNext()) {
			Node aitem = (Node) ( iterator.next());
			if(aitem.data.equals("deliveryTime")|| aitem.data.equals("rating")) {
    		if (((Restaurant) aitem.middle).getCuisine().equals(" Pizza")) {
    			System.out.println(((Restaurant) aitem.middle).getName()+"   "+((Restaurant) aitem.middle).getDeliveryTime());
    			return aitem;
    		}}
    		if(aitem.data.equals("price")|| aitem.data.equals("stock")) {
    			Restaurant tempRestaurant =  ((Food) aitem.middle).getRestaurant();
    			if(tempRestaurant.getCuisine().equals(" Coffee")) {
    			stack.push(aitem);		}    		}	}
		Node<T> aObject = stack.pop();
		if(aObject==null ){
			
		}
		else {
		Food tempFood = (Food) aObject.middle;
		System.out.println(tempFood.getName()+"   "+tempFood.getStock());
		return null;
		}
		return getRootNode();}

	@SuppressWarnings({  "unchecked" })
	public Comparator<T> createComparator() {
		String tName = getRootNode().middle.getClass().getName();
		String typeBST = getRootNode().data;
		if(tName=="Food") {
			if(typeBST=="price") {
				OurComparator.PriceComparator comparator1 = new OurComparator.PriceComparator();
				comparator=(Comparator<T>) comparator1;
			}
			else if(typeBST=="stock") {
				OurComparator.StockComparator comparator1 = new OurComparator.StockComparator();
				comparator=(Comparator<T>) comparator1;
			}
		}
		
		else {
			if(typeBST=="deliveryTime") {
				OurComparator.DeliveryComparator comparator1 = new OurComparator.DeliveryComparator();
				comparator=(Comparator<T>) comparator1;
			}
			else if(typeBST=="rating") {
				OurComparator.RatingComparator comparator1 = new OurComparator.RatingComparator();
				comparator=(Comparator<T>) comparator1;
			}
		}
		return comparator;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Node<T> add(Node current,Node item){
    	comparator = createComparator();    	
    	if(current==null) {return item;}
    	int result = comparator.compare((T)item.middle,(T) current.middle);
    		if (result==1) {
    			if(current.right==null) {
    				current.right=item;
    			}
    			else {
    	    		current.right = add(current.right, item);			
    			}
			} //
    		
    		else if(result==-1){
    			if(current.left==null) {
    				current.left=item;
    			}
 		
    			else {
    	    		current.left = add(current.left, item);
    		}	}
    		else if(result==0) {
    			if(getRootNode().data=="rating"||getRootNode().data.equals("deliveryTime")) {
    				numberOfItems-=1;
    				
    				}
    			
    			else {
    				
    			if(current.left==null) {
        			 current.left=item;	
        			 
        			 }
    			
    			else {
    	    		current.left = add(current.left, item);	}
    			
    			} 			}
    		
    		return current;    	
	}
	

	
	

	
	
	
	public void remove(Node T) {
		 remove(rootNode, T);
		numberOfItems--;
	}

	
    @SuppressWarnings("unchecked")
	private T minValue(Node node) {
    	 
        if(node.left != null) {
            return minValue((Node) node.left);
        }
        return (T) node.middle;
    }		
	
    public void showRemoval() {
    	while(!printQueue.isEmpty()) {
    		@SuppressWarnings("unchecked")
			Node<Food> tempNode = (Node<Food>) printQueue.dequeue();
    	System.out.println(tempNode.middle.getName()+"     "+tempNode.middle.getPrice()+ " removed");
    }
    	printQueue.setTail(0);
    }
    
	public void showRemoval1() {
    	while(!printStack.isEmpty()) {
			@SuppressWarnings("unchecked")
			Node<Restaurant> tempNode = (Node<Restaurant>) printStack.pop();
    	System.out.println(tempNode.middle.getName()+"  "+tempNode.middle.getRating()+" removed");
    }}
    
    
    
    
    
    
	@SuppressWarnings({ "unchecked", "unused",  })
	public Node<T> remove(@SuppressWarnings("rawtypes") Node root, @SuppressWarnings("rawtypes") Node u) {
		
		comparator=createComparator();
		int result = comparator.compare((T)u.middle, (T)root.middle);
		if(root==null) {return null;}
		if(result==1) {
			root.right = remove(root.right, u);
		}
		else if(result==-1){
			root.left = remove( root.left,u);

		}
		else {
			if(root.left==null&&root.right==null) {
				printStack.push((T) u);
				printQueue.enqueue((T) u);
				
				return null;
			}
			else if(root.getLeft() == null) {
				printStack.push((T) u);
				printQueue.enqueue((T) u);

                return root.right;
            } else if(root.getRight() == null) {
				printStack.push((T) u);
				printQueue.enqueue((T) u);

                return root.left;
            } else {
            	T  valueT = minValue(root.right);
            	root.middle=valueT;
            	root.right = remove(root.right,u );
				printStack.push((T) u);
				printQueue.enqueue((T) u);       }      }
        return root;				}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Node<T> add(Node item) {
		
    	if( getRootNode()==null) {
    		setRootNode(new Node<>(item.data));
    		((Node<T>) getRootNode()).middle=(T) item.middle;
    	}
    	else {
    	setRootNode(add(getRootNode(), item));   
    	}
    	numberOfItems+=1;
		return item;			
	}
	
    
	@SuppressWarnings("unchecked")
	public void InOrderTraversalAscenging() {
    	iterator = new OurIterator<>(getRootNode());
    	iterator = (Iterator<T>) iterator;
    	while(iterator.hasNext()) {
    		System.out.println(((Node<T>)iterator.next()).middle.toString());    
    		 		}    	}
    
  
	public void InOrderTraversalDescending() {
    	Iterator<Node<T>> baboIterator = new OurIterator<>(getRootNode());
    	Stack<Node<T>> stack = new Stack<>();
    	
    	while(baboIterator.hasNext()) {
    		stack.push(baboIterator.next());    }
    		
    	while(!stack.isEmpty()) {
    	Node<T> tempNode= stack.pop();

    	System.out.println(tempNode.middle.toString());
    	}
    	}
    public boolean isEmpty() {
    	return rootNode==null;
    }
    
	public Node<T> getRootNode() {
		return rootNode;
	}
	public void setRootNode(Node<T> rootNode) {
		this.rootNode = rootNode;
	}}