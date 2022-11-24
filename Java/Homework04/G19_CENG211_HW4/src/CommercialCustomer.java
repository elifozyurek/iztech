
public class CommercialCustomer implements ICustomer{
	
	private static int numberOfSilvers=0;
	private static int numberOfGolds=0;
	private static int numberOfPlatinums=0;
	private String id;
	private String customerType;
	
	
	public CommercialCustomer(String id) {
		this.id = id;
		groupMembersByType();
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public static int getNumberOfSilvers() {
		return numberOfSilvers;
	}

	public static int getNumberOfGolds() {
		return numberOfGolds;
	}

	public static int getNumberOfPlatinums() {
		return numberOfPlatinums;
	}

	public String getCustomerType() {
		return customerType;
	}	
	
	@Override
	public double calculateDiscount() {
		char type = id.charAt(0);
		double discount = 0;
		switch (type) {
			case 'S': {
				discount = 0.2;
				break;
			}
			case 'G': {
				discount = 0.25;
				break;
			}
			case 'P': {
				discount = 0.3;
				break;
			}
		}
		return discount;
	}

	@Override
	public void groupMembersByType() {
		char type = id.charAt(0);
		switch (type) {
			case 'S': {
				numberOfSilvers++;
				customerType = "Silver";
				break;
			}
			case 'G': {
				numberOfGolds++;
				customerType = "Gold";
				break;
			}
			case 'P': {
				numberOfPlatinums++;
				customerType = "Platinum";
				break;
			}
		}
	}

}
