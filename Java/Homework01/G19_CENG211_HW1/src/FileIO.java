import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
	public static void BookReader(String fileName, Library library) {

		try {
			Scanner keyboardScanner = new Scanner(new File(fileName));
			String line;

			while (keyboardScanner.hasNextLine()) {

				line = keyboardScanner.nextLine();

				String[] data = line.split(",");
				String idString = data[0];
				String titleString = data[1];
				String authorString = data[2];
				String publisherString = data[3];
				int edition = Integer.parseInt(data[4]);
				String genreString = data[5];
				int quantitiy = Integer.parseInt(data[6]);

				library.addBook(new Book(idString, titleString, authorString, publisherString, edition, genreString,
						quantitiy));

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static Issue[] IssueReader(String fileName, Library library, Member[] members) {

		try {

			Issue[] issueArr = new Issue[50];

			Scanner keyboardScanner = new Scanner(new File(fileName));
			String line;
			Book tempBook = null;
			Member tempMember = null;
			int index = 0;

			while (keyboardScanner.hasNextLine()) {

				line = keyboardScanner.nextLine();

				String[] data = line.split(",");
				int issueId = Integer.parseInt(data[0]);
				int memberIdString = Integer.parseInt(data[1]);
				String bookIdString = data[2];
				String issueDateString = data[3];
				String returningDateString = data[4];
				String numberOfLibrary = fileName.substring(1, 2); //to found which library that needs to be incremented

				for (int i = 0; i < library.getNumberOfBooks(); i++) {	//in this loop, we increased the times issued of the  book that is issued.
					if (library.getBooks()[i].getId().equals(bookIdString)) {
						tempBook = library.getBooks()[i];
						library.getBooks()[i].incrementTimesIssued();
					}
				}

				for (int i = 0; i < members.length; i++) {	//in this loop, we increased the times issued of the member that reads the book.
					if (members[i].getId() == memberIdString) {
						tempMember = members[i];
						members[i].incrementIssue(Integer.parseInt(numberOfLibrary) - 1);
					}
				}

				issueArr[index] = new Issue(issueId, tempMember, tempBook, issueDateString, returningDateString); // the new issue object is created.
				index++;

			}
			return issueArr;

		}

		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	public static Member[] MemberReader(String fileName) {

		try {

			Scanner keyboardScanner = new Scanner(new File(fileName));
			String line;
			Member[] members = new Member[4];
			int index = 0;

			line = keyboardScanner.nextLine();
			while (keyboardScanner.hasNextLine()) {

				line = keyboardScanner.nextLine();
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String nameString = data[1];
				String emailString = data[2];

				if (nameString.equals("admin")) {
					continue;
				} // for not considering "admin" as a member

				else {
					Member member = new Member(id, nameString, emailString);
					members[index] = member;
					index++;
				}

			}

			return members;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
