public class IndefiniteGame extends Game{
	
	private int minEvalTime;

	public IndefiniteGame(String name,   double rating,int evalTime,int arrivalDay) {
		super(name, rating,arrivalDay);
		this.minEvalTime=evalTime;
	}

	public int getMinEvalTime() {
		return minEvalTime;
	}

	public void setMinEvalTime(int minEvalTime) {
		this.minEvalTime = minEvalTime;
	}

	@Override
	public double calculateRating() {

		return getRating()+((10-getMinEvalTime())*0.25);
	}

	
	
	
}
