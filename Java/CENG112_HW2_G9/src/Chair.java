
public class Chair implements IProduct {
	private String productName;
	
	private boolean success = false;
	
	public void setSuccess(boolean process) {
		this.success = process;
	}
	
	public Chair(String name) {
		productName = name;
		
	}
	
	public String toString() {
		return productName;
	}
	
	@Override
	public boolean isManufactured() {
		return success;
	}

	@Override
	public boolean isStored() {
		return success;
	}

	@Override
	public boolean isSold() {
		return success;
	}

}
