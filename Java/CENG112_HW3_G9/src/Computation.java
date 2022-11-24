

public class Computation {
	
	private int id;	
	
	private IProcess process;
	
	private int occupation;
	
	public Computation(IProcess process,int occupation, int idno) {
		this.id=idno;
		this.process=process;
		this.occupation=occupation;}
	
	
	public String toString() {
		assert process.getPriority()==3||process.getPriority()==2||process.getPriority()==1;
		switch (process.getPriority()) {
		case 1: {return process.toString()+occupation;}
		case 2:{return process.toString()+occupation;}
		case 3:{return process.toString()+occupation;}}	
		return null;}
	
	
	public int getId() {
		return id;}
	
	public IProcess getProcess() {
		return process;}
	
	public int getOccupation() {
		return occupation;}
	
	
}
