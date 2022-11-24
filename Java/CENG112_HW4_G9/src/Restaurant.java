
public class Restaurant {
	private String name;
	private double rating;
	private String cuisine;

	private int deliveryTime; 
	
	public Restaurant(String name1,double rating1,String cousine1,int deltime) {
		setName(name1);
		setRating(rating1);
		setCuisine(cousine1);
		this.deliveryTime=deltime;
	}
	
	public String toString() {
		String spaceString = "";
		for(int i = name.length()+Double.toString(rating).length();i<33;i++) {
			spaceString+=" ";
		}
		return name+spaceString+rating;
	}
	
	public String ratingString() {
		return "rating";
	}
	
	public String deliveryTimeString() {
		return "deliveryTime";
	}

	public void updateCuisine(String category) {
		this.cuisine=category;
	}
	
	public void updateRating(double score) {
		this.rating=score;
	}
	
	public void updateDeliveryTime(int deliveryTime)	{
		this.deliveryTime=deliveryTime;
	}
	
	public double getRating() {
		return rating;	}
	
	public void setRating(double rating) {
		this.rating = rating;	}

	public String getCuisine() {
		return cuisine;	}
	
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;	}

	public String getName() {
		return name;	}
	
	public void setName(String name) {
		this.name = name;	}
	
	public int getDeliveryTime() {
		return deliveryTime;	}
	
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;	}
	
}
