
public class EducationalApplication extends Application{


	public EducationalApplication(String applicantName, String applicantId, Passport passport, Photo applicantPhoto,
			Document[] documents) {
		
		super(applicantName, applicantId, passport, applicantPhoto, documents);
		
	}

	public EducationalApplication( String applicantId,String applicantName) {
		super(applicantId,applicantName);
	}
	
	
	
	@Override
	public boolean validationForFinancialStatus() {

		if(getFinancialStatus()==null) {
			System.out.print("Rejected, Reason: Applicant does not have a financial status report");
			return false;
		}
		
		if(!(getFinancialStatus().getIncome()>=1000)) {
			System.out.print("Rejected, Reason: Applicant does not have a stable financial status");

			return false;}
		
		boolean hasIL = false;
		for (Document document : getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("IL")) {
				hasIL=true;
			}
		}
		
		int income = getFinancialStatus().getIncome();
		int savings = getFinancialStatus().getSavings();
		if(hasIL) {

			if(income>=500 && 1000>income && savings>=3000) {
				return true;
			}	
			else if(income>=1000 && 1500>income && savings>=1500) {

				return true;
			}
			else if(income>=1500) {

				return true;
			}
			else {
				System.out.print("Rejected, Reason: Applicant does not have a stable financial status");
				return false;
			}
				
		}
		else {

			if(income>=1000 && 2000>income && savings>=6000) {
				return true;
			}	
			else if(income>=2000 && 3000>income && savings>=3000) {
				return true;
			}
			else if(income>=3000) {
				return true;
			}
			else {
				System.out.print("Rejected, Reason: Applicant does not have a stable financial status");
				return false;
			}
		}
		
	}

	@Override
	public boolean validationForDocument() {
		for (Document document :getDocuments()) {
			if(document==null) break;
			if(document.getDocumentType().equals("LA")) {
				return true;
			}
		}
		System.out.print("Rejected, Reason: Applicant does not have a letter of acceptance");
		return false;
	}

	@Override
	public boolean visaDuration() {
		int acceptanceMonth=-1;
		for (Document document : super.getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("LA")) {
				acceptanceMonth = Integer.parseInt(document.getDurationInMonthString());
			}
		}
		
		
		if(validationForPassport(this)) {
			int monthsForPassport = getPassport().getMonths();

			
			if(monthsForPassport<12) { 	
				System.out.print("Rejected, Reason: Passport expiration date is not valid ");
				
				return false;
			}
		
			else {
				if(acceptanceMonth>monthsForPassport) {
					double year =  (monthsForPassport/12);
					if(year>=1 && year<2) {
						setVisa("Accepted, Visa Duration : 1 year");
						return true;
					}
					else if(year>=2 && year<4) {
						setVisa("Accepted, Visa Duration : 2 years");
						return true;
					}
					else if(year>=4) {
						setVisa("Accepted, Visa Duration : 4 years");
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
					else if(acceptanceMonth>24 && monthsForPassport<48) {
						setVisa("Accepted, Visa Duration : 2 years");
						return true;
					}
					else {
						setVisa("Accepted, Visa Duration : 4 years");
						return true;
					}
							
				}	
				
			}
				
			
		}
		return false;
		
	}
	
}
