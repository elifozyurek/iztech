
public class LibraryManagement {

	private Issue[][] issues;
	private int index;

	public LibraryManagement() {
		super();
		this.issues = new Issue[3][50]; // 50 is the default length since we do not know the length of the file at the
										// beginning.
		this.index = 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Issue[][] getIssues() {

		Issue[][] tempIssues = new Issue[3][50];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < tempIssues[i].length; j++) {
				tempIssues[i][j] = this.issues[i][j];
			}
		}

		return tempIssues;
	}

	public void setIssues(Issue[][] issues) {
		this.issues = issues;
	}

	public void addIssueArr(Issue[] arr) {

		issues[index] = arr;
		setIndex(getIndex() + 1);
	}

}