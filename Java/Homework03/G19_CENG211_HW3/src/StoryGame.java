

public class StoryGame extends Game{

	private int storyDuration;
	
	public StoryGame(String name, double rating,int storyDuration,int arrivalDay) {
		super(name, rating,arrivalDay);
		this.storyDuration=storyDuration;
	}

	public int getStoryDuration() {
		return storyDuration;
	}

	public void setStoryDuration(int storyDuration) {
		
		this.storyDuration = storyDuration;
	}

	@Override
	public double calculateRating() {
		return getRating()+ (storyDuration* 0.25);
		
	}
 

}
