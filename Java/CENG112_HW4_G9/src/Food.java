

public class Food implements Orderable {
	private String name;
	private double price;
	private int stock;
	private Restaurant restaurant;
	
	public Food(String name1,double price1,int stock1,Restaurant r) {
		name=name1;
		setPrice(price1);
		stock=stock1;
		restaurant=r;
		}
	
	public String getName() {
		return this.name;
		
	}
	
	public String toString() {
		String spaceString = "";
		for(int i = name.length()+Double.toString(price).length();i<25;i++) {
			spaceString+=" ";
		}
		String ou = " ";
		for(int i = Double.toString(stock).length();i<14;i++) {
			ou+=" ";
		}
		return " "+name+spaceString+price+ou+stock;
		}
	
	public String priceString() {
		return "price";
	}
	
	public String stockString() {
		return "stock";
	}
	@Override
	public void updatePrice(double number) {
		String aString = String.valueOf(Float.valueOf((float) (price*((100+number)/100))));
		if(aString.length()==6) {
			this.price = Double.valueOf(aString.substring(0, 5));
		}
		else if(aString.length()==4) {
			this.price = Double.valueOf(aString.substring(0, 4));

		}
	}
	
	@Override
	public void updateStock(int stock) {
		this.stock /= (100/stock);
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;	}


	public int getStock() {
		return stock;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
