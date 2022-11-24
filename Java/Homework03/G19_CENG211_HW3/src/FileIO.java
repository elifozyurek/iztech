import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class FileIO {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Stack<Movie> movies = new Stack();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Stack<Game> games = new Stack();
	

	public Stack<Movie> getMovies() {
		return movies;
	}



	public Stack<Game> getGames() {
		return games;
	}
	
	/*
	 *  We read contents.csv  according to arrival days.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void read(int day) throws FileNotFoundException {
	
		Scanner keyboardScanner = new Scanner(new File("contents.csv"));
		String line;
		
		while (keyboardScanner.hasNextLine()) {

			line = keyboardScanner.nextLine();
			String[] data = line.split(",");
	
			if(data.length<=1)break;
			if(Integer.parseInt(data[0]) != day ) 
				continue;
			
			switch (data[1]) {
			
				case "0": {
					Movie movie = new Movie(data[2],
						 Double.parseDouble(data[5]), Integer.parseInt(data[0]), 
						Integer.parseInt(data[4]),Integer.parseInt(data[3]));
					
					movies.push(movie);
					break;
				
				}
				case "1":{
					Game game = new IndefiniteGame(data[2], Double.parseDouble(data[4]), Integer.parseInt(data[3]),Integer.parseInt(data[0]));
					games.push(game);
					break; 
				}
				case "2":{
					
					Game game = new StoryGame(data[2], Double.parseDouble(data[4]), Integer.parseInt(data[3]),Integer.parseInt(data[0]));
					games.push(game);
					break;	
				
				}
				case "3":{
					
					Game game = new CasualGame(data[2], Double.parseDouble(data[4]), Integer.parseInt(data[3]),Integer.parseInt(data[0]));
					games.push(game);
					break;
				
				}
				

					
			}
			
	
		
		
		}
		
	
		Stack<Movie> smovies = new Stack();
		int sizeM = movies.size();
		for(int i =0;i<sizeM;i++) {
		
			
			smovies.push(movies.pop());
		}
		movies=smovies;

		
		Stack<Game> sgames = new Stack();
		int size = games.size();
		for(int i =0;i<size;i++) {
		
			
			sgames.push(games.pop());
		}
		games=sgames;
		
		
		
	
}
		
	

	
}