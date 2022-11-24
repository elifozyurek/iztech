
public abstract class Application {
	private String visa="";
	private String applicantName;
	private String applicantId;
	private Passport passport;	
	private Photo applicantPhoto;
	private Document[] documents =  new Document[5];
	private FinancialStatus financialStatus;

	private int numberOfDocuments=0;
	
	public Application() {
		this("no id", "no name");
	}

	public Application( String applicantId,String applicantName ) {
		this.applicantName = applicantName;
		this.applicantId = applicantId;

	}
	
	public Application( String applicantId,String applicantName, Passport passport,
			Photo applicantPhoto,Document[] documents) {
		this.applicantName = applicantName;
		this.applicantId = applicantId;
		this.passport = passport;
		this.applicantPhoto = applicantPhoto;
		this.documents = documents;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Photo getApplicantPhoto() {
		return applicantPhoto;
	}

	public void setApplicantPhoto(Photo applicantPhoto) {
		this.applicantPhoto = applicantPhoto;
	}

	public Document[] getDocuments() {
		return documents;
	}

	public void setDocuments(Document document) {
		this.documents[numberOfDocuments] = document;
		numberOfDocuments++;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	
	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}
	
	public FinancialStatus getFinancialStatus() {
		return financialStatus;
	}


	public void setFinancialStatus(FinancialStatus financialStatus) {
		this.financialStatus = financialStatus;
	}
	
	
	public int getNumberOfDocuments() {
		return numberOfDocuments;
	}


	public void setNumberOfDocuments(int numberOfDocuments) {
		this.numberOfDocuments = numberOfDocuments;
	}

		
	private boolean isNumericPassport() {
		
		String lastThreeDigit = getPassport().getPassportNumber().substring( getPassport().getPassportNumber().length()-3 );
		for(int i =0;i<lastThreeDigit.length();i++) {
			if("0123456789".indexOf(lastThreeDigit.charAt(i)) == -1   ) {
				return false;
			}	
		}
		
		return true;
	}
	
	
	public boolean validationForPassport(Application applicant) {
		if(applicant.getPassport() == null) {
			System.out.print("Rejected, Reason: Applicant does not have a passport");
			return false;
		}
		
		if(applicant.getPassport().getPassportNumber().length() != 10 || 
				!applicant.getPassport().getPassportNumber().substring(0, 1).equals("P") ||
				 !(isNumericPassport()) ) {
			
			System.out.print("Rejected, Reason: Passport is not valid");
			return false;
		}
		
		else {
			int monthsForPassport = getPassport().getMonths();
		
			
			if(monthsForPassport <6) {
				System.out.print("Rejected, Reason: Passport expiration date is not valid");
				return false;
			}
			return true;
			
			}
	
	}
	
	
	public boolean validationForPhoto(Application applicant) {
		if(applicant.getApplicantPhoto() == null) {
			System.out.print("Rejected, Reason: Applicant does not have a photo");
			return false;
		}
		
		String[] resolutions = applicant.getApplicantPhoto().getResolution().split("x");
		
		if(Integer.parseInt(resolutions[0])==Integer.parseInt(resolutions[1])) {
			
			if(Integer.parseInt(resolutions[0])>=600 && Integer.parseInt(resolutions[0])<=1200) {
				if(applicant.getApplicantPhoto().getPosition().equals("Neutral Face") ||
						applicant.getApplicantPhoto().getPosition().equals("Natural Smile")) {
					return true;
				}	
				else {
					System.out.print("Rejected, Reason: Position in the photo is not valid");
					return false;
				}
			}
			else {
				System.out.print("Rejected, Reason: Resolution of photo is not valid");
				return false;
			}	
		}
		else {
			System.out.print("Rejected, Reason: Resolution of photo is not valid");
			return false;
		}
		
	}
	
	
	public abstract boolean validationForFinancialStatus();
	
	public abstract boolean validationForDocument() ;
	
	public abstract boolean visaDuration();

}
