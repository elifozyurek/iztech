
public class Process implements IProcess {
	String processName;
	int priority;
	
	public Process(String name,int no) {
		this.processName=name;
		this.priority=no;
	}
	
	
	public String toString() {
		return processName+","+getType();
	}
	
	public String getType() {
		switch (priority) {
		case 1: {return "High,";}
		case 2:{return "Normal,";}
		case 3:{return "Low,";}
		}
		return null;
	}

	public int getPriority() {
		return priority;
	}

}
