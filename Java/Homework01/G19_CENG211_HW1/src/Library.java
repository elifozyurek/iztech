
public class Library {

	private Book[] books;
	private int numberOfBooks;
	private final int lengthOfArray = 35; // 35 is the default length since we do not know the length of the file at the
											// beginning.

	public Library() {
		setNumberOfBooks(0);
		Book[] tempBook = new Book[lengthOfArray];
		books = tempBook;

	}

	public Library(Book[] books, int numberOfBooks) {
		this.books = books;
		this.numberOfBooks = numberOfBooks;
	}

	public void display() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public Book[] getBooks() {
		Book[] tempBooks = new Book[lengthOfArray];
		for (int i = 0; i < tempBooks.length; i++) {
			tempBooks[i] = this.books[i];
		}
		return tempBooks;
	}

	public void setBooks(Book[] book) {
		this.books = book;
	}

	public Book indexAt(int index) {
		for (int i = 0; i < books.length; i++) {
			if (i == index)
				return this.books[i];
		}
		return null;
	}

	public void addBook(Book book) {
		this.books[getNumberOfBooks()] = book;
		this.setNumberOfBooks(this.getNumberOfBooks() + 1);
	}

	public int getLengthOfArray() {
		return this.lengthOfArray;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

}
