
public class ImmigrantApplication extends Application{
	

	public ImmigrantApplication(String applicantName, String applicantId, Passport passport, Photo applicantPhoto,
			Document[] documents) {
		
		super(applicantName, applicantId, passport, applicantPhoto, documents);
		
	}

	public ImmigrantApplication( String applicantId,String applicantName) {
		super(applicantId,applicantName);

	}
	
	@Override
	public boolean validationForFinancialStatus() {
		
		if(getFinancialStatus()==null) {
			System.out.print("Rejected, Reason: Applicant does not have a financial status report");
			return false;
		}
		

		int necessarySaving = 50000;
		

		
		for (Document document : getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("GC")) {
				necessarySaving=4000;
			}		
		}
		
		for (Document document : getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("IL")) {
				necessarySaving/=2;
				}
		}
		
		
		if(getFinancialStatus().getSavings()>=necessarySaving) {
			return true;
		}
		else {
			System.out.print("Rejected, Reason: Applicant does not have a stable financial status");
			return false;
		}
	
	}
	
	@Override
	public boolean validationForDocument() {
		//Its not necessary to have a specific document.
		return true;
	}

	@Override
	public boolean visaDuration() {
		setVisa("Accepted, Visa Duration : Permanent");
		return true;
	}

}



