// by Sam Dunny

public class VideoGame {
	
	// instance variables
	private String name = "";
	private String console = "";
	
	// default constructor
	public VideoGame() {
		this.name = "none";
		this.console = "none";
	}
	
	// parameterized constructor
	public VideoGame(String aName, String aCon) {
		this.setName(aName);
		this.setConsole(aCon);
	}
	
	// mutators
	public void setName(String aName) {
		if (aName != null)
			this.name = aName;
		else {
			System.out.println("Invalid Name Input, using defaults");
			this.name = "none";
		}
	}
	public void setConsole(String aCons) {
		if (aCons != null)
			this.console = aCons;
		else {
			System.out.println("Invalid Console Input, using defaults");
			this.console = "none";
		}
	}
	
	// accessors
	public String getName() {
		return this.name;
	}
	public String getConsole() {
		return this.console;
	}
	
	// returns string with with instance values
	public String printValues() {
		return this.name + "\t" + this.console;
	}
	
	// isEqualTo method, returns true if this video game has the same values as input
	public boolean isEqualTo(String aName, String aCons) {
		if (this.name.equalsIgnoreCase(aName) &&
				this.console.equalsIgnoreCase(aCons))
			return true;
		return false;
	}

}