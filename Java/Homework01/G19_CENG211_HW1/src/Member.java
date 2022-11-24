
public class Member {
	private int id;
	private String name,email;
	private int[] library = {0,0,0}; //first index for the first library, and the rest the same as the first index.
	
	public Member(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	
		
	}
	public Member() {
		super();
	}
	
	public int[] getLibrary() {
		
		return library;
	}

	public void setLibrary(int[] library) {
		this.library = library;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	/*
	 * for each library, we took how many books issued
	 * for each member.
	 * 
	 * @param index of library
	 * 
	 */
	public void incrementIssue(int index) {
		library[index]++;
	}


	/*
	 * total issued books for that member.
	 * 
	 */
	public int getNumberOfIssuedBooks() {

		
		int sum = 0;
	
		for (int i =0;i<library.length;i++) {
			sum+=library[i];
		}
		return sum;
		
	}


}
