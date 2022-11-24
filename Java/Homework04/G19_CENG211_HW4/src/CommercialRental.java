
public class CommercialRental extends Rental{

	private static int commercialsRented=0;
	private static int commercialsMonths=0;
	private int numberOfMonths;
	
	public CommercialRental(String carModel, int carModelYear, double basePrice,int numberOfMonths,ICustomer customer) {
		super(carModel, carModelYear, basePrice,customer);
		commercialsRented = getCommercialsRented() + 1;
		this.numberOfMonths = numberOfMonths;
		commercialsMonths = getCommercialsMonths() + numberOfMonths;
	}
	
	
	public static int getCommercialsRented() {
		return commercialsRented;
	}

	public static int getCommercialsMonths() {
		return commercialsMonths;
	}
	
	public int getNumberOfMonths() {
		return numberOfMonths;
	}
	
	@Override
	public double calculateRentalPrice() {
		double rentalTemp = getDailyPrice()*numberOfMonths*30;
		rentalTemp = rentalTemp*(1-(getCustomer().calculateDiscount()));
		setRentalPrice(rentalTemp);
		return rentalTemp;
	}

}
