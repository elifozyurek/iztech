
public class FinancialStatus {

	private int income;
	private int savings;

	public FinancialStatus(int income, int savings) {
		this.income = income;
		this.savings = savings;
	}

	public int getSavings() {
		return savings;
	}
	
	public void setSavings(int savings) {
		this.savings = savings;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
		
}
