
public abstract class Content {
	
	private String name;
	private double averageRating;
	private int arrivalDay;

	
	public Content(String name, double averageRating,int arrivalDay) {
		this.name = name;
		this.averageRating = averageRating;
		this.arrivalDay=arrivalDay;
	}


	public String getName() {
		return name;
	}



	public int getArrivalDay() {
		return arrivalDay;
	}


	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
 

	public void setName(String name) {
		this.name = name;
	}


	public double getRating() {
		return this.averageRating;
	}


	public void setAverageRating(double avgRating) {
		if(avgRating>=100) {
		
			this.averageRating=100;
		}
		else {
			this.averageRating = avgRating;

		}
	}


	public abstract double calculateRating();
}
