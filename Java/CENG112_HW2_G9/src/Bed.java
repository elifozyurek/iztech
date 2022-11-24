

public class Bed implements IProduct {
	private String productName;
	private boolean success = false;

	
	public void setSuccess(boolean process) {
		this.success = process;
	}
	
	public boolean getSuccess() {
		return success;
	}
	
	public Bed(String name) {
		productName = name;	}
	
	public String toString() {
		return productName;	}
	
	public boolean controlProduct() {
		return true;
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
