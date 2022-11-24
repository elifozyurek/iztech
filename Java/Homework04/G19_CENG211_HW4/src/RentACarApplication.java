/*
 *  Ceren Çaðlayan 270201059
 *  Elif Özyürek 280201079
 *  
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RentACarApplication {
	/*
	 * Our diagrams are in same directory with csv file.
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		FileIO fileIO = new FileIO();
		fileIO.read();
		ArrayList<Rental> rentals = new ArrayList<>();
		rentals.addAll(fileIO.getCommercialList());
		rentals.addAll(fileIO.getIndividualList());
		
		for (Rental rental : rentals) {
			rental.calculateRentalPrice();
		}
		for (Rental rental : rentals) {
			rental.giveARentalCode();
		}

		RentalDisplayer rentalDisplayer = new RentalDisplayer();
		rentalDisplayer.display(fileIO.getIndividualList(),fileIO.getCommercialList());

	}
}
