import java.util.Comparator;

public class GameCriticComparator implements Comparator<ICritic>{
	


	@Override
	public int compare(ICritic o1, ICritic o2) {
		// TODO Auto-generated method stub
		return   ((GameCritic) o2).getJobHour()-((GameCritic) o1).getJobHour();
	}
}
