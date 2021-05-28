// by Sam Dunny

package Homework00_ShowcaseShowdown;
public class Prize {
    
    // Instance variables
    private int price;
    private String name;

    // Default values
    private int DEF_price = 0;
    private String DEF_name = "Default";
    

    // Default constructor
    public Prize() {
        this.price = DEF_price;
        this.name = DEF_name;
    }

    // Parameterized constructor
    public Prize(int aPrice, String aName) {
        this.setPrice(aPrice);
        this.setName(aName);
    }

    // Accessors
    public int  getPrice() {
        return this.price;
    }
    public String getName() {
        return this.name;
    }

    // Mutators
    public void setPrice(int aPrice) {
        if (aPrice >= 0)
            this.price = aPrice;
        else {
            System.out.println("INVALID price parameter [" + aPrice + "], using DEFAULT: " + DEF_price);
            this.price = DEF_price;
        }
    }
    public void setName(String aName) {
        if (aName != null && aName.length() != 0)
            this.name = aName;
        else {
            System.out.println("INVALID name parameter [" + aName + "], using DEFAULT: " + DEF_name);
            this.name = DEF_name;
        }
    }

    // Equals method to determine if two Prizes are the same
    public boolean Equals(Prize aP) {
        if (this.price == aP.getPrice() &&
            this.name.equalsIgnoreCase(aP.getName()))
                return true;
        return false;
    }

    // toString method to print prize's attributes
    public String toString() {
        return "Name:\t" + this.name + "\nPrice:\t" + this.price;
    }
}