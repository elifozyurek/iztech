
public abstract class Rental {
	
	private static int carsRented=0;
	private String carModel;
	private int carModelYear;
	private double basePrice;
	private int rentalCode;
	private ICustomer customer;
	private double dailyPrice;
	private double rentalPrice;
	

	public Rental(String carModel, int carModelYear, double basePrice,ICustomer customer) {
		this.carModel = carModel;
		this.carModelYear = carModelYear;
		this.basePrice = basePrice;
		this.customer=customer;
		carsRented = getCarsRented() + 1;
		calculateDailyPrice();
	}
	

	public double getRentalPrice() {
		return rentalPrice;
	}


	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}


	public double getDailyPrice() {
		return dailyPrice;
	}


	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}


	public static int getCarsRented() {
		return carsRented;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public int getCarModelYear() {
		return carModelYear;
	}
	
	public void setCarModelYear(int carModelYear) {
		this.carModelYear = carModelYear;
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public ICustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	
	public int getRentalCode() {
		return rentalCode;
	}
	
	public void giveARentalCode() {
		rentalCode = (int) Math.floor(Math.random() * Math.random()*(10000000) )+1000000 ;
	}
	
	// calculates daily price for each rental that depends on model year of the car.
	public void calculateDailyPrice() {
		double ratio = 1; // it's default 
	
		switch (carModelYear) {
			case 2022: {
				ratio=1;
				break;
			}
			case 2021: case 2020 : {
				ratio=0.95;
				break;
			}
			case 2019: case 2018 : case 2017: {
				ratio=0.9;
				break;
			}
		}
		setDailyPrice(basePrice*ratio);
		
	}
	
	public abstract double calculateRentalPrice();
	
}
