
public abstract class Game extends Content{


	public Game(String name,  double rating,int arrivalDay) {
		super(name, rating,arrivalDay);
		
	} 

	@Override
	public abstract double calculateRating();
	
	
	
}
