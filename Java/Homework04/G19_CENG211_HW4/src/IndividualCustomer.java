

public class IndividualCustomer<T> implements ICustomer {
	
	private static int numberOfNonMembers=0;
	private static int numberOfMembers=0;
	private T id;
	private boolean isMember;
	

	public IndividualCustomer(T id,boolean isMember) {
		this.setId(id);
		this.isMember=isMember;
		groupMembersByType();
	}
	
	public static int getNumberOfMembers() {
		return numberOfMembers;
	}
	
	public static int getNumberOfNonMembers() {
		return numberOfNonMembers;
	}  
	
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
	public boolean isMember() {
		return isMember;
	}
	
	public String returnMembership() {
		if(isMember) {
			return "yes";
		}
		return "no";
	}

	@Override
	public double calculateDiscount() {
		if(isMember()) {
			return 0.1;
		}
		return 0;
	}

	@Override
	public void groupMembersByType() {
		if(isMember()) {
			numberOfMembers++;
		}
		else {
			numberOfNonMembers++;
		}
		
	}

}
