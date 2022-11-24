
public class Document {

	private String documentType;
	private String durationInMonthString="";
	
	public Document() {
		this("no type assigned", "");
		
	}

	public Document(String documentType, String durationInMonthString) {
		this.setDocumentType(documentType);
		this.setDurationInMonthString(durationInMonthString);
	}

	public Document(String documentType) {
		this.setDocumentType(documentType);
	}

	public String getDurationInMonthString() {
		return durationInMonthString;
	}

	public void setDurationInMonthString(String durationInMonthString) {
		this.durationInMonthString = durationInMonthString;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	
}
