/*
 * Elif Özyürek 280201079
 * Ceren Caðlayan 270201059
 * 
 */


import java.util.ArrayList;


public class VisaApplication {

	public static void ApplicationProcess(ArrayList<Application> applications) {
		for (Application application : applications) {
			String applicationType=application.getClass().getName().
					substring(0,application.getClass().getName().indexOf("A"));
			System.out.print("Applicant ID:"+application.getApplicantId()+", Name:"+
			application.getApplicantName()+", Visa Type:"+
					applicationType+ ", Status: ");
			
			if(application.validationForPassport(application)) {
				if(application.validationForPhoto(application)) {
					if(application.validationForFinancialStatus()) {
						if(application.validationForDocument()) {
			
							application.visaDuration();
							System.out.print(application.getVisa());
						}
					}
				}
			}

			System.out.println();
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<Application> applicants = FileIO.attiributeReader();
		VisaApplication.ApplicationProcess(applicants);
	
	}
	
	
}
