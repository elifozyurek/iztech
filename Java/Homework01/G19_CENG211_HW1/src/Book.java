
public class Book {
	
	private int edition,quantity;
	private String id, title, author, publisher,genre ;
	private int timesIssued;
	
	public Book(String id,String title, String author, String publisher, int edition,String genre, int quantity) {
		super();
		this.id = id;
		this.edition = edition;
		this.genre = genre;
		this.quantity = quantity;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	public Book() {
		super();
		this.id = null;
		this.edition =0 ;
		this.genre = null;
		this.quantity = 0;
		this.title = null;
		this.author = null;
		this.publisher = null;
		this.setTimesIssued(0);
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public int getEdition() {
		return this.edition;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public String getGenre() {
		return genre;
	}
	
	
	public void setGenre(String genre) {
		this.genre = genre;

	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getTimesIssued() {
		return timesIssued;
	}
	
	public void setTimesIssued(int timesIssued) {
		this.timesIssued = timesIssued;
	}
	

	public void incrementTimesIssued() { //to increment issued times of the related book object.
		this.setTimesIssued(this.getTimesIssued() + 1);
		}


}
