
public class IndividualRental extends Rental{

	private static int individualsRented=0;
	private static int individualsDays=0;
	private int numberOfDays;
	

	public IndividualRental(String carModel, int carModelYear, double basePrice,int numberOfDays,ICustomer customer) {
		super(carModel, carModelYear, basePrice,customer);
		this.numberOfDays = numberOfDays;
		individualsDays = getIndividualsDays() + numberOfDays;
		individualsRented = getIndividualsRented() + 1;
	}
	
	public static int getIndividualsRented() {
		return individualsRented;
	}

	public static int getIndividualsDays() {
		return individualsDays;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	

	
	@Override
	public double calculateRentalPrice() { 
		double rentalTemp = getDailyPrice()*numberOfDays;
		rentalTemp = rentalTemp*(1-getCustomer().calculateDiscount());
		setRentalPrice(rentalTemp);
		return rentalTemp;
	}

}
