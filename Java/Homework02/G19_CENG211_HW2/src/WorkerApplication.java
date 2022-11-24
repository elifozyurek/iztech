

public class WorkerApplication extends Application {
	

	
	public WorkerApplication(String applicantName, String applicantId, Passport passport, Photo applicantPhoto,
			Document[] documents) {
		
		super(applicantName, applicantId, passport, applicantPhoto, documents);
		
	}

	public WorkerApplication( String applicantId,String applicantName) {
		super(applicantId,applicantName);
	}
	
	@Override
	public boolean validationForFinancialStatus() {	
		if(getFinancialStatus()==null) {
		System.out.print("Rejected, Reason: Applicant does not have a financial status report");
		return false;
	}
		if(getFinancialStatus().getSavings()>=2000) {
			return true;
		}
		else {
			System.out.print("Rejected, Reason: Applicant does not have a stable financial status");
			return false;
		}
	}

	
	@Override
	public boolean validationForDocument() {
		for (Document document : getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("LA"))
				return true;
		}
		System.out.print("Rejected, Reason: Applicant does not have a letter of acceptance");
		return false;
	}

	@Override
	public boolean visaDuration() {
		int acceptanceMonth=-1;
		for (Document document : getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("LA")) {
				acceptanceMonth = Integer.parseInt(document.getDurationInMonthString());
			}
		}

		
		if(validationForPassport(this)) {
			
			int monthsForPassport = getPassport().getMonths();

			if(monthsForPassport<12) {
				System.out.print("Rejected, Reason: Passport expiration date is not valid");
				return false;

			}
			
		
			else {
				if(acceptanceMonth>monthsForPassport) {
					double year =  (monthsForPassport/12);
					if(year>=1.0 && year<2.0) {
						setVisa("Accepted, Visa Duration : 1 year");
						return true;
					}
					else if(year>=2 && year<5 ) {
						setVisa("Accepted, Visa Duration : 2 years");
						return true;
					}
					else if(year>=5) {
						setVisa("Accepted, Visa Duration : 5 years");
						return true;
					}
					
				}
				else {
					if(acceptanceMonth<=12) {
						setVisa("Accepted, Visa Duration : 1 year");
						return true;
					}
					else if(acceptanceMonth>12 && acceptanceMonth<=24 && monthsForPassport<24) {
						setVisa("Accepted, Visa Duration : 1 year");
						return true;

					}
					else if(acceptanceMonth>12 && acceptanceMonth<=24 && monthsForPassport>=24) {
						setVisa("Accepted, Visa Duration : 2 years");
						return true;

					}
					else if(acceptanceMonth>24 && monthsForPassport<60) {
						setVisa("Accepted, Visa Duration : 2 years");
						return true;
					}
					else {
						setVisa("Accepted, Visa Duration : 5 years");
						return true;
					}
				
				}	
					
			}
			
		}
		
		System.out.print("Rejected, Reason: Passport expiration date is not valid ");
		return false;
		
	}

	
	
	
	
}
