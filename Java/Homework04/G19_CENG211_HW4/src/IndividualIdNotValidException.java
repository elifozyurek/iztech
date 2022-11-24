
@SuppressWarnings("serial")
public class IndividualIdNotValidException extends Exception {

	public IndividualIdNotValidException() {
		super("Individual basic");
	}

	public IndividualIdNotValidException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
