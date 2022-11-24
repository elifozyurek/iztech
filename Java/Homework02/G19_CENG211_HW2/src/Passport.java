import java.util.Calendar;

public class Passport {

	private String passportNumber;
	private int months;
	private String expirationDate;
	
	public Passport(String passportNumber, String expirationDate ){
		this.passportNumber=passportNumber;
		this.expirationDate=expirationDate;
		calculateMonths();
	}	
	
	
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}
	
	public void calculateMonths() {
		Calendar calendarPassport = Calendar.getInstance();		
		String[] strings = expirationDate.split("-");
		Calendar calendarToday = Calendar.getInstance();	
		
		// 
		calendarToday.set(2021, 11, 28);
		
		calendarPassport.set(Integer.parseInt(strings[0]),Integer.parseInt(strings[1])
				,Integer.parseInt(strings[2]));
		
		long time = calendarPassport.getTimeInMillis() - calendarToday.getTimeInMillis();
		float monthsBetween = (time / (1000 * 60 * 60 * 24))/30;
		this.months=(int) monthsBetween;

	}
	
	
	
	
	
	
}
