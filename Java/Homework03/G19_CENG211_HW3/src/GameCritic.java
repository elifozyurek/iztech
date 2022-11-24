
public class GameCritic implements ICritic{

	private int opinion,id;
	private int jobHour = 8;
	
	private int remainingTime = 0;
	private Game continuingGame;
	private Game gameDone;

	public GameCritic(int opinion,int id) {
		super();
		this.opinion = opinion;
		this.id = id;
	}
 

	@Override
	public void makeRating( Content content ) {
		content.setAverageRating(content.calculateRating()+opinion );
	}
	
	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public void doJob(int hour) {
		if(hour>jobHour) {
			setJobHour(0);
		}
		else {
			setJobHour(getJobHour() - hour);

		}
	}
	
	public void renewJob() {
		setJobHour(8);
	}


	public int getJobHour() {
		return jobHour;
	}


	public void setJobHour(int jobHour) {
		this.jobHour = jobHour;
	}

	public Game getContinuingGame() {
		return continuingGame;
	}

	public void setContinuingGame(Game continuingGame) {
		this.continuingGame=continuingGame;
	}



	public Game getGameDone() {
		return gameDone;
	}

 

	public void setGameDone(Game gameDone) {
		this.gameDone = gameDone;
	}


	public int getRemainingTime() {
		return remainingTime;
	}


	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}


	
}
