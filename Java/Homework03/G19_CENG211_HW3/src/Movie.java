
public class Movie  extends Content{
	
	
	private int year,  duration;// dakika
	

	public Movie(String name, double averageRating, 
			int arrivalDay, int duration,int year) {
		super(name, averageRating,arrivalDay);
		this.year = year;

		this.duration = duration;
	}

	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}



	@Override
	public double calculateRating() {
		
		return getRating()+((duration-150)*0.01 )-((2021-year)*0.01);
	}
	

}
