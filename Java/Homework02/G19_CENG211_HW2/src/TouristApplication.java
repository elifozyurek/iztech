
public class TouristApplication extends Application {


	public TouristApplication(String applicantName, String applicantId, Passport passport, Photo applicantPhoto,
			Document[] documents) {
		
		super(applicantName, applicantId, passport, applicantPhoto, documents);
		
	}

	public TouristApplication( String applicantId,String applicantName) {
		super(applicantId,applicantName);
	}

	
	@Override
	public boolean validationForFinancialStatus() {
		if(getFinancialStatus()==null) {
			System.out.print("Rejected, Reason: Applicant does not have a financial status report");
			return false;
		}

		boolean hasIL = false;
		for (Document document : getDocuments()) {
			if(document==null) break;
			if(document.getDocumentType().equals("IL")) {
				hasIL=true;
			}
		}

		
		int income = getFinancialStatus().getIncome();
		int savings = getFinancialStatus().getSavings();
		if(hasIL) {
			if(income>=1000 && 1500>income && savings>=6000) {
				return true;
			}	
			else if(income>=1500 && 2000>income && savings>=3000) {
				return true;
			}
			else if(income>=2000) {
				return true;
			}
			else {
				System.out.print("Rejected, Reason: Applicant does not have a stable financial status");
				return false;
			}
				
		}
		else {
			if(income>=2000 && 3000>income && savings>=12000) {
				return true;
			}	
			else if(income>=3000 && 4000>income && savings>=6000) {
				return true;
			}
			else if(income>=4000) {
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
		return true;
	}

	private boolean hasAnInvitationLetter() {
		for (Document document : getDocuments()) {
			if(document==null)break;
			if(document.getDocumentType().equals("IL"))
				return true;
		}
		return false;
	}

	@Override
	public boolean visaDuration() {
		double dc=0;
		double year = -1;
		if(hasAnInvitationLetter()) {
			dc = ( ( (getFinancialStatus().getIncome() - 2000) * 6 ) + getFinancialStatus().getSavings() )/6000 ;

		}
		else {
			dc = ( ( (getFinancialStatus().getIncome() - 2000) * 6 ) + getFinancialStatus().getSavings()) /12000 ;

		}
		
		if(1<=dc && 2>dc) {
			year=0.5;
		}
		else if(2<=dc && 4>dc) {
			year=1;
		}
		else if(dc>=4) {
			year=5;
		}
	
		
		int monthsForPassport = getPassport().getMonths();
		
		if(monthsForPassport<=year*12) {
			if(6<=monthsForPassport && monthsForPassport<12) {
				setVisa("Accepted, Visa Duration : 6 Months");
				return true;
			}
			else if(12<=monthsForPassport && monthsForPassport<60) {
				setVisa("Accepted, Visa Duration : 1 year");
				return true;
			}
			else{
				setVisa("Accepted, Visa Duration : 5 Years");
				return true;
			}
		}
		else {
			if(year==0.5) {
				setVisa("Accepted, Visa Duration : 6 Months");
				return true;
			}
			setVisa("Accepted, Visa Duration : "+(int) year +" years");
			return true;
		}
		

	}
	
	
	
	
	

}
