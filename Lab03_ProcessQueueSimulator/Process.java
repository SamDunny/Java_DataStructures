// by Sam Dunny

public class Process {

	// instance variables
	private String name;
	private double completionTime;
	
	// default constructor
	public Process() {
		this.name = "none";
		this.completionTime = 0.0;
	}
	
	// parameterized constructor
	public Process(String aName, double aCompTime) {
		this.setName(aName);
		this.setCompletionTime(aCompTime);
	}
	
	// accessors
	public String getName() {
		return this.name;
	}
	public double getCompletionTime() {
		return this.completionTime;
	}
	
	// mutators
	public void setName(String aName) {
		if (aName == null)
			this.name = "none";
		this.name = aName;
	}
	public void setCompletionTime(double aCompTime) {
		if (aCompTime >= 0.0)
			this.completionTime = aCompTime;
		else
			this.completionTime = 0.0;
	}
	
	// toString method, prints out instance values
	public String toString() {
		return "Process Name: " + this.name + " Completion Time: " + this.completionTime;
	}
}
