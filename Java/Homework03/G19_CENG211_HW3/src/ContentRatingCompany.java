/*
 * Ceren Çaðlayan 270201059
 * Elif Özyürek 280201079
 * 
 */

import java.io.FileNotFoundException;

public class ContentRatingCompany {

	public static void main(String[] args) throws FileNotFoundException {
		Simulation simulation = new Simulation();
		simulation.make();
		ContentDisplayer contentDisplayer = new ContentDisplayer(simulation.getGamesToBeSorted(), simulation.getMoviesToBeSorted());
		contentDisplayer.display();
	}

}
