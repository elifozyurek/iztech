
public class CasualGame extends Game{

	private int matchDuration;
	
	public CasualGame(String name,  double rating,int matchDuration,int arrivalDay) {
		super(name, rating,arrivalDay);
		this.matchDuration=matchDuration;
	}

	public int getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(int matchDuration) {
		this.matchDuration = matchDuration;
	}

	@Override
	public double calculateRating() {
		return getRating()+((getMatchDuration()-3)*3);
	}


}
