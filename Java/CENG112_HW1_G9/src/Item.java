
public class Item {
	private String item_name;
	private  int item_weight;
	private String item_compartment;

	
	public Item(String Name,String copartment,int Weight){
		
		this.item_name=Name;
		this.item_compartment=copartment;
		this.item_weight=Weight;
	} 
	
	public int getWeight() {
		return item_weight;
	}
	public String getName() {
		return item_name;
	}
	public String getCompartment() {
		return item_compartment;
	}
	
	public String toString() {
		
		return item_name;		
		
	}
	
	public boolean equals() {
		return false;
	}

	
	
	
	
}
