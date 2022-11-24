
public class MovieCritic implements ICritic{
	private double opinion;
	private int id;
	private boolean isEvaluated = false;

	public MovieCritic(double opinion,int id) {
		super();
		this.opinion = opinion;
		this.id=id;
	}

	@Override
	public void makeRating(Content content) {
		if(!isEvaluated) {
			content.setAverageRating(content.calculateRating()+opinion);
			isEvaluated=true;
		}
		
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	public void renewJob() {
		isEvaluated=false;
		
	}
	

	

}
