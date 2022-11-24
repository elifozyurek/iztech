/*
 * 
 * Sude Nur Çevik 270201041
 * Elif Özyürek 280201079
 * Ceren Çaðlayan 270201059
 * 
 */

public class LibraryManagementApp { 
	public static void main(String[] args) {
		LibraryQuery libraryQuery = new LibraryQuery();
		System.out.print("1) ");
		libraryQuery.printMostIssuedBook();
		System.out.print("2) ");
		libraryQuery.printMemberMostIsssued();
		System.out.print("3) ");
		libraryQuery.printHighestPenalty();
		System.out.print("4) ");
		libraryQuery.printMostCopied();
		System.out.print("5) ");
		libraryQuery.printLeastCopiedInIssues();
		System.out.print("6) ");
		libraryQuery.printMemberLeastIssued();

	}

}
