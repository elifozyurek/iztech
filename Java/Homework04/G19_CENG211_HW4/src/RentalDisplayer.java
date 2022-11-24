import java.util.ArrayList;

public class RentalDisplayer {
	

	@SuppressWarnings("unchecked")
	public <T> void display(ArrayList<Rental> individualRentals,ArrayList<Rental> commercialRentals) {
		System.out.println("Welcome!");
		System.out.println("Total number of cars rented: "+(individualRentals.size()+commercialRentals.size()));
		System.out.println("Total number of commercial rentals: "+ CommercialRental.getCommercialsRented());
		System.out.println("Total number of commercial rental-month: "+ CommercialRental.getCommercialsMonths());
		System.out.println("Total number of individual rentals: "+IndividualRental.getIndividualsRented());
		System.out.println("Total number of individual rental-day: "+IndividualRental.getIndividualsDays());
		System.out.println("Total number of rentals of individual non-member customers: "+IndividualCustomer.getNumberOfNonMembers());
		System.out.println("Total number of rentals of individual member customers: "+IndividualCustomer.getNumberOfMembers());
		System.out.println("Total number of rentals of silver commercial customers: "+CommercialCustomer.getNumberOfSilvers());
		System.out.println("Total number of rentals of gold commercial customers: "+CommercialCustomer.getNumberOfGolds());
		System.out.println("Total number of rentals of platinum commercial customers: "+CommercialCustomer.getNumberOfPlatinums());
	
		System.out.println("Individual Rentals:");
		System.out.println("No     Rental Code   Customer ID       isMember     Number of Days     Car Model          Model Year        Rental Price");
		for (int i =0;i<individualRentals.size();i++) {
			Rental rental = individualRentals.get(i);

			System.out.printf("%d       %d       ",i+1,rental.getRentalCode());
			System.out.printf("%-12.12s",String.valueOf(((IndividualCustomer<T>) rental.getCustomer()).getId()));
			System.out.printf("      %-10.10s        %-8s    %-20s   %-4d             %6.2f",((IndividualCustomer<T>) rental.getCustomer()).returnMembership(),
					String.valueOf(((IndividualRental) rental).getNumberOfDays()),rental.getCarModel(),rental.getCarModelYear(),
					rental.getRentalPrice());
			System.out.println();
		
			
		}
		System.out.println();
		System.out.println("Commercial Rentals:");
		System.out.println("No     Rental Code   Customer ID     Customer Type   Number of Months     Car Model           Model Year  Rental Price");
		for (int i =0;i<commercialRentals.size();i++) {
			Rental rental =commercialRentals.get(i);
			System.out.printf("%d       %d       ",i+1,rental.getRentalCode());
			System.out.printf("%-12.12s",String.valueOf(((CommercialCustomer) rental.getCustomer()).getId()));
			System.out.printf("    %-10.10s          %-8s      %-20s     %-4d       %6.2f",((CommercialCustomer) rental.getCustomer()).getCustomerType(),
					String.valueOf(((CommercialRental) rental).getNumberOfMonths()),rental.getCarModel(),rental.getCarModelYear(),
					rental.getRentalPrice());
			System.out.println();
			
		}
	
	}
	
}
