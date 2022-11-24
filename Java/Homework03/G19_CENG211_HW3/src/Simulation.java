import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Simulation{
		
	Queue<ICritic> gameCritics = new LinkedList<>();
	Queue<ICritic> movieCritics= new LinkedList<>();
	ArrayList<Game> gamesToBeSorted = new ArrayList<>();
	ArrayList<Movie> moviesToBeSorted = new ArrayList<>();
	FileIO fileIO = new FileIO();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Stack<Movie> movies = new Stack();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Stack<Game> games = new Stack();

		public Simulation() throws FileNotFoundException  {
			
			ICritic gameCritic1 = new GameCritic(5, 1);
			ICritic gameCritic2 = new GameCritic(9, 2);
			ICritic gameCritic3 = new GameCritic(-3, 3);
			ICritic gameCritic4 = new GameCritic(2, 4);
			ICritic gameCritic5 = new GameCritic(-7, 5);
			
			gameCritics.add(gameCritic1);
			gameCritics.add(gameCritic2);
			gameCritics.add(gameCritic3);
			gameCritics.add(gameCritic4);
			gameCritics.add(gameCritic5);
			
			ICritic movieCritic1 = new MovieCritic(0.1, 1); 
			ICritic movieCritic2 = new MovieCritic(-0.2, 2); 
			ICritic movieCritic3 = new MovieCritic(0.3, 3); 

			movieCritics.add(movieCritic1);
			movieCritics.add(movieCritic2);
			movieCritics.add(movieCritic3);
	
		}
		
		public ArrayList<Game> getGamesToBeSorted() {
			return gamesToBeSorted;
		}

		public ArrayList<Movie> getMoviesToBeSorted() {
			return moviesToBeSorted;
		}
		
		public void make() throws FileNotFoundException {
			
			int days=5;
			ArrayList<ICritic> continuingJobs = new ArrayList<ICritic>();;
			ArrayList<ICritic> jobsDone = new ArrayList<>();
			
			
			for (int i =0;i<days;i++) {
				
				System.out.println("Day:"+(i+1));
				fileIO.read(i+1); 
					
				// Games are read for each day in company.
				int sizeOfGames = fileIO.getGames().size();
				for (int g =0;g<sizeOfGames;g++) {
					games.push(fileIO.getGames().pop());
				}
				// Movies are read for each day in company.
				int sizeOfMovies = fileIO.getMovies().size();
				for (int m =0;m<sizeOfMovies;m++) {
					movies.push(fileIO.getMovies().pop());
				}				
			
				// There are at most 3 movies that can be evaluated in a day.
				int jobCounterMovieCritic = 0;
				for (int a =0;a<15;a++) {
					if(jobCounterMovieCritic !=3 && movies.size() != 0) {
					
						
						Movie movie1 = movies.pop();	// the movie that will be evaluated  :)		
						ICritic critic = movieCritics.poll(); // the critic that will evaluate.						
						critic.makeRating(movie1);
						
						System.out.println(critic.getId()+". movie critic evaluated (#"+movie1.getName()+")");		
						moviesToBeSorted.add(movie1); 
						jobCounterMovieCritic+=1;
						movieCritics.add(critic); // after the job is done, critic is added to the back of the queue.
					}
				}
				
				
				int jobCounterGameCritic = 0; // For checking if all game critics are evaluating a game.
				
				/*
				 * 	For next days,if the critic cannot finish evaluating the game
				 * in one day,we update remaining time.
				 * 
				 * If remaining time is 0, the job is done in the day that we check.
				 * And we add the critic to the jobsDone which is an ArrayList for 
				 * checking evaluations that is done.
				 */
				int size = continuingJobs.size();
				Collections.sort(continuingJobs, new GameCriticComparator()); // we sorted their jobs in ascending order.
				for(int q = 0;q<size;q++) {
					ICritic continuingCritic = continuingJobs.remove(0); // we take critic
					continuingCritic.renewJob(); // because we look in new day, we renew the job time for worker.
					
					((GameCritic) continuingCritic).doJob(((GameCritic) continuingCritic).getRemainingTime());
					((GameCritic) continuingCritic).setRemainingTime(((GameCritic) continuingCritic).getRemainingTime()
							- (8-((GameCritic) continuingCritic).getJobHour()) );
					
					/*
					 * If remaining time is greater than zero, we 
					 * add continuingJobs again and look again for days after.
					 *  
					 */
					if(((GameCritic)continuingCritic).getRemainingTime()>0){		
						continuingJobs.add(continuingCritic);
						continue;
					}		  
					
					Game game= ((GameCritic)continuingCritic).getContinuingGame();
					((GameCritic)continuingCritic).setGameDone(game);
					
					jobsDone.add(continuingCritic); 
					jobCounterGameCritic--;
					
				} 

				for(int q =0;q<17;q++) {
					if(jobCounterGameCritic!=5 && games.size() != 0) {
						Game game = games.pop();
						ICritic critic = gameCritics.poll();
						int time=0;
						if(critic!=null) {
						if(((GameCritic) critic ).getJobHour()==0) {
							gameCritics.add(critic);
							gamesToBeSorted.add(game);
							continue;
						}
				
						switch (game.getClass().getName()) {
							case "CasualGame":{							
								time = ((CasualGame) game).getMatchDuration() * 3;	
								break;
							}	
							case "IndefiniteGame":{
								time=4;
								break;
							}
							case "StoryGame":{
								time = ((StoryGame) game).getStoryDuration();
								break;
							}
					
						}

						if(((GameCritic) critic ).getJobHour() >= time) {			
							((GameCritic) critic ).doJob(time);
							critic.makeRating(game);
							System.out.println(critic.getId()+". game critic works on (#"+game.getName()+")");
							((GameCritic) critic).setGameDone(game);
							jobsDone.add(critic);	
							
						}
						else {
							
							System.out.println(critic.getId()+". game critic works on (#"+game.getName()+")");
							if(i!=4) {
							critic.makeRating(game);
							((GameCritic)critic).setContinuingGame(game);

							((GameCritic) critic).setRemainingTime(
									time -  ((GameCritic) critic).getJobHour() );
									((GameCritic) critic).doJob(time);

							continuingJobs.add(critic);					

						    }
							
						}
						
						jobCounterGameCritic++;
						}
						gamesToBeSorted.add(game);
						
						/*
						 *	If we have a critic that finished evaluating a game in that day, 
						 *we printed and put the critic back into the queue
						 */
						Collections.sort(jobsDone, new GameCriticComparator()); // we sorted their jobs.
						if(jobCounterGameCritic==5 || games.size() == 0 || critic==null ){
							int sizeJobsDone = jobsDone.size();
							for(int index=0;index<sizeJobsDone;index++) {
								ICritic critic1 = jobsDone.remove(0);
							
					 			System.out.println(critic1.getId()+". game critic evaluated (#"+
					 					((GameCritic)critic1).getGameDone().getName()+")");	
					 			
					 			jobCounterGameCritic--;
								gameCritics.add(critic1);
								if(games.size()>0) {
									break;// If there are games that have not been evaluated yet,
										//we need to assign them to critics in the queue, so we broke the loop.
								}
								
							}
							
						}
					}
				}
					

				// Renewing the jobHour for critics who are in queue for next day.
				for(ICritic worker: gameCritics) {	
					worker.renewJob();
				}
				
				for(ICritic worker: movieCritics) {	
					worker.renewJob();
				}
									
			}
		
			/*
			 * If no evaluated game and movie exist, we also take them 
			 * for displaying and sorting.
			 */
			for (Game game2 : games) {
				gamesToBeSorted.add(game2);
			}
				
			for (Movie movie2 : movies) {
				moviesToBeSorted.add(movie2);
			}	
	
	}
		
}
