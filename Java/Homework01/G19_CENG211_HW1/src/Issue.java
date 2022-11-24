public class Issue {
	private int id;
	private Member member;
	private Book book;
	private String issueDateString, returningDateString;
	
	public Issue(int id, Member member, Book book, String issueDateString, String returningDateString) {
		super();
		this.id = id;
		this.member = member;
		this.book = book;
		this.issueDateString = issueDateString;
		this.returningDateString = returningDateString;
	}

	public Issue() {
		super();
		this.id = 0;
		this.member = null;
		this.book = null;
		this.issueDateString = null;
		this.returningDateString = null;
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getIssueDateString() {
		return issueDateString;
	}

	public void setIssueDateString(String issueDateString) {
		this.issueDateString = issueDateString;
	}

	public String getReturningDateString() {
		return returningDateString;
	}

	public void setReturningDateString(String returningDateString) {
		this.returningDateString = returningDateString;
	}
	
}
