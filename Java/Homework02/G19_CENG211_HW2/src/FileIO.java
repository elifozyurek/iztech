import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;

	
public class FileIO {
	
	public static ArrayList<Application> applicantReader() {

		ArrayList<Application> applicantArrayList = new ArrayList<>();

		try {
			Scanner keyboardScanner = new Scanner(new File("HW2_ApplicantsInfo.csv"));
			String line;
			
			while (keyboardScanner.hasNextLine()) {

			line = keyboardScanner.nextLine();
			String[] data = line.split(",");
			if (data[0].equals("A")) {
				switch (data[1].substring(0,2)) {
				case "11": {
					Application tourist = new TouristApplication(data[1],data[2]);
					applicantArrayList.add(tourist);
					break;
				}
				case "23": {
					Application worker = new WorkerApplication(data[1],data[2]);
					applicantArrayList.add(worker);
					break;
				}
				case "25": {
					Application educational = new EducationalApplication(data[1],data[2]);
					applicantArrayList.add(educational);
					break;
					
				}				
				case "30": {
					Application immigrant = new ImmigrantApplication(data[1],data[2]);
					applicantArrayList.add(immigrant);
					break;
				}
			
			}
			
		}
		}
		}	
			 catch (FileNotFoundException e) {
			System.out.println(e.getMessage());}
		
		
	

		return applicantArrayList;
		
		
	}
	
	public static ArrayList<Application> attiributeReader() {
		
		ArrayList<Application> applicantArrayList = applicantReader();

		try {
	
			Scanner keyboardScanner = new Scanner(new File("HW2_ApplicantsInfo.csv"));
			String line;
			int index =0;		
					
			while (keyboardScanner.hasNextLine()) {

			line = keyboardScanner.nextLine();
			String[] data = line.split(",");
			
			for (int a = 0;a<applicantArrayList.size();a++) {
				if(data[1].equals(applicantArrayList.get(a).getApplicantId())) {
					index=a;
				}
			}
			
			if( data[0].equals("D")) {
				Document document;
				
				if(data.length==3) {
	
					document = new Document(data[2]);
				}
				else {
					
					 document= new Document(data[2], data[3]);
					}
				applicantArrayList.get(index).setDocuments(document);
							
				
				
			}
			else if( data[0].equals("F")) {
				FinancialStatus financialStatus = new FinancialStatus(Integer.parseInt(data[2]),
														Integer.parseInt(data[3]));
				applicantArrayList.get(index).setFinancialStatus(financialStatus);
			}
				
			else if( data[0].equals("P")) {
				Photo photo = new Photo(data[2],data[3]);
				applicantArrayList.get(index).setApplicantPhoto(photo);
			}							
			else if( data[0].equals("S")) {
				Passport passport = new Passport(data[2],data[3]);
				applicantArrayList.get(index).setPassport(passport);
			
			}
		
		
			}
			
		
		}	
			 catch (FileNotFoundException e) {
			System.out.println(e.getMessage());}
		
		applicantArrayList = sortArray(applicantArrayList);
		return applicantArrayList;
	
	}
	
	
	
	private static  ArrayList<Application> sortArray(ArrayList<Application> applications) {
		
		ArrayList<Application> applicants2 = new ArrayList<>();
		int initialSize = applications.size();
		 
		for(int a =0; a<initialSize;a++) {
			Application minApplicant=applications.get(0);
			
			for (int i =0; i<applications.size();i++) {
				int id = Integer.parseInt(applications.get(i).getApplicantId());
				if(Integer.parseInt(minApplicant.getApplicantId() ) > id){
					minApplicant=applications.get(i);
				
				}
	
			}

			if(applications.size()==1) {
				applicants2.add(minApplicant);
				break;
			}
	
			applications.remove(minApplicant);
			
			applicants2.add(minApplicant);
		
		}
		
		return applicants2;
		
	}
	
	
	
	
	
	
}
		
		
