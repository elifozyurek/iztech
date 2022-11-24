import java.util.Calendar;

public class LibraryQuery {
	// we chose to call methods of the FileIO class statically.
	LibraryManagement libraryManagement = new LibraryManagement();
	Library library1 = new Library();// Central Library
	Library library2 = new Library();// School of Foreign Languages Library
	Library library3 = new Library();// Computer Science Library
	Member[] members;
	Issue[] issue1;
	Issue[] issue2;
	Issue[] issue3;

	public LibraryQuery() {

		FileIO.BookReader("L1_Books.csv", library1);
		FileIO.BookReader("L2_Books.csv", library2);
		FileIO.BookReader("L3_Books.csv", library3);
		members = FileIO.MemberReader("Members.csv");
		issue1 = FileIO.IssueReader("L1_Issues.csv", library1, members);
		issue2 = FileIO.IssueReader("L2_Issues.csv", library2, members);
		issue3 = FileIO.IssueReader("L3_Issues.csv", library3, members);
		libraryManagement.addIssueArr(issue1);
		libraryManagement.addIssueArr(issue2);
		libraryManagement.addIssueArr(issue3);

	}

	public LibraryQuery(Issue[][] issues, LibraryManagement libraryManagement, Library library1, Library library2,
			Library library3, Member[] members, Issue[] issue1, Issue[] issue2, Issue[] issue3) {

		this.libraryManagement = libraryManagement;
		this.library1 = library1;
		this.library2 = library2;
		this.library3 = library3;
		this.members = members;
		this.issue1 = issue1;
		this.issue2 = issue2;
		this.issue3 = issue3;
	}

	public void printMostIssuedBook() {

		int maximum = 0;
		Book tempBook = null;

		for (int i = 0; i < 3; i++) {
			for (int a = 0; i < 50; a++) {
				if (libraryManagement.getIssues()[i][a] == null)
					break;
				if (libraryManagement.getIssues()[i][a].getBook().getTimesIssued() > maximum) {
					maximum = libraryManagement.getIssues()[i][a].getBook().getTimesIssued();
					tempBook = libraryManagement.getIssues()[i][a].getBook();
				}
			}
		}
		System.out.println(tempBook.getTitle());
	}

	public void printMemberMostIsssued() {

		int max = 0;
		Member tempMember = null;

		for (Member member : members) {
			if (member.getNumberOfIssuedBooks() > max) {
				max = member.getNumberOfIssuedBooks();
				tempMember = member;
			}
		}
		System.out.println(tempMember.getName());

	}

	public void printHighestPenalty() {

		String[] monthString = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }; //to recognize the months.
		int[] monthInteger = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }; //to find the months as numerics.
		double maxPunishment = -1;

		for (int i = 0; i < 3; i++) {
			for (int a = 0; i < 50; a++) {
				if (libraryManagement.getIssues()[i][a] == null)
					break;

				int issueDateMonth = 0;
				int returnDateMonth = 0;
				String[] issueDate = libraryManagement.getIssues()[i][a].getIssueDateString().split("-");
				String[] returnDate = libraryManagement.getIssues()[i][a].getReturningDateString().split("-");

				for (int j = 0; j < monthString.length; j++) {
					if (issueDate[1].equals(monthString[j])) {
						issueDateMonth = monthInteger[j];
					}
					if (returnDate[1].equals(monthString[j])) {
						returnDateMonth = monthInteger[j];
					}
				}

				Calendar calendarIssueCalendar = Calendar.getInstance();
				Calendar calendarReturnCalendar = Calendar.getInstance();

				calendarIssueCalendar.set(Integer.parseInt(issueDate[2]), issueDateMonth,
						Integer.parseInt(issueDate[0]));

				calendarReturnCalendar.set(Integer.parseInt(returnDate[2]), returnDateMonth,
						Integer.parseInt(returnDate[0]));

				long time = calendarReturnCalendar.getTimeInMillis() - calendarIssueCalendar.getTimeInMillis();
				float daysBetween = (time / (1000 * 60 * 60 * 24));

				if (daysBetween <= 14) {
					continue;
				}

				double punishment = (daysBetween - 14) * (0.5);
				if (punishment > maxPunishment)
					maxPunishment = punishment;

			}

		}
		System.out.println(maxPunishment + " TL");
	}

	public void printMostCopied() {

		int maximum = 0;

		Book tempBook = null;
		Book[][] allBooks = { library1.getBooks(), library2.getBooks(), library3.getBooks() };

		for (int i = 0; i < 3; i++) {
			for (int a = 0; i < 50; a++) {

				if (allBooks[i][a] == null)
					break;

				if (allBooks[i][a].getQuantity() > maximum) {
					maximum = allBooks[i][a].getQuantity();
					tempBook = allBooks[i][a];
				}
			}
		}

		System.out.println(tempBook.getTitle());

	}

	public void printLeastCopiedInIssues() {

		int min = 1000;
		Book tempBook = null;

		for (int i = 0; i < 3; i++) {
			for (int a = 0; i < 50; a++) {
				if (libraryManagement.getIssues()[i][a] == null)
					break;

				if (libraryManagement.getIssues()[i][a].getBook().getQuantity() <= min) {
					min = libraryManagement.getIssues()[i][a].getBook().getQuantity();
					tempBook = libraryManagement.getIssues()[i][a].getBook();

				}

			}
		}
		System.out.println(tempBook.getTitle());

	}

	public void printMemberLeastIssued() { // for computer science library

		int min = 1000;
		Member tempMember = null;

		for (Member member : members) {

			if (member.getLibrary()[2] < min) {
				min = member.getLibrary()[2];
				tempMember = member;
			}
		}
		System.out.println(tempMember.getName());

	}

}
