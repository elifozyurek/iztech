
@SuppressWarnings("serial")
public class CommerciallIdNotValidException extends Exception{

	public CommerciallIdNotValidException() {
		super("Id for Commercial customer is not valid.");
	}

	public CommerciallIdNotValidException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}


}
