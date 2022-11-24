import java.util.ArrayList;
import java.util.Arrays;

public class ContentDisplayer {
	
	private ArrayList<Game> gamesSorted = new ArrayList<>();
	private ArrayList<Movie> moviesSorted = new ArrayList<>();
	
	
	public ContentDisplayer(ArrayList<Game> gamesSorted, ArrayList<Movie> moviesSorted) {
		this.gamesSorted = gamesSorted;
		this.moviesSorted = moviesSorted;
	}

	
	private void sort() {
		System.out.println();
		System.out.println("Ratings:");
		
		ArrayList<Game> sortedGamesToPrint = new ArrayList<>();
		ArrayList<Movie> sortedMoviesToPrint = new ArrayList<>();

		
		
		String[] names = new String[16];
		int i =0;
		for (Game game: gamesSorted ) {
			if(game==null)
				continue;

			names[i]=game.getName();
			i++;

		}
		
		
		String[] names2 = new String[15];
		int a =0;
		for (Movie movie: moviesSorted ) {
			if(movie==null)break;
			names2[a]=movie.getName();
			a++;

		}

		
		Arrays.sort(names);
		Arrays.sort(names2);
		
		
		
		
		for (String string2 : names) {
			for(Game game : gamesSorted) {
				if(string2.equals(game.getName())) {
					sortedGamesToPrint.add(game);
					
				}
			}
		}
		for (String string3 : names2) {
			for(Movie movie : moviesSorted) {
				if(string3.equals(movie.getName())) {
					sortedMoviesToPrint.add(movie);
					
				}
			}
		}
		
		System.out.println();

		moviesSorted=sortedMoviesToPrint;
		gamesSorted=sortedGamesToPrint;

	
		
		
		
	}
	
	
	public void display() {
		sort();
		
		for (Movie movie : moviesSorted) {
			System.out.print("# "+movie.getName()+"(#"+movie.getYear()+")"+" Rating: ");
			System.out.printf("%5.2f",movie.getRating());
			System.out.println();
		}
		System.out.println();

		
		for (Game game : gamesSorted) {
			
			System.out.print("# "+game.getName()+" Rating: ");
			System.out.printf("%d",(int)game.getRating());
			System.out.println();
			
		}
		
		
	}

	
	
	
	
	
	

}
