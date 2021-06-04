// by Sam Dunny

package Lab06_FruitTree;

public class Fruit implements Comparable<Fruit>{
    
    // Instance variables
    private double weight;
    private String type;

    // Default values
    private double DEF_weight = 1.0;
    private String DEF_type = "Apple";

    // Default constructor
    public Fruit() {
        this.weight = DEF_weight;
        this.type = DEF_type;
    }

    // Parameterized constructor
    public Fruit(double aWeight, String aType) {
        this.setWeight(aWeight);
        this.setType(aType);
    }

    // Accessors
    public double getWeight() {
        return this.weight;
    }
    public String getType() {
        return this.type;
    }

    // Mutators
    public void setWeight(double aWeight) {
        if (aWeight > 0.0)
            this.weight = aWeight;
        else {
            System.out.println("FRUIT invalid weight[" + aWeight + "], set to DEFAULT: " + DEF_weight);
            this.weight = DEF_weight;
        }
    }
    public void setType(String aType) {
        if (aType != null && aType.length() != 0 && (
            aType.equalsIgnoreCase("Apple") ||
            aType.equalsIgnoreCase("Orange") ||
            aType.equalsIgnoreCase("Banana") ||
            aType.equalsIgnoreCase("Kiwi") ||
            aType.equalsIgnoreCase("Tomato")))
                this.type = aType;
        else {
            System.out.println("FRUIT invalid type[" + aType + "], set to DEFAULT: " + DEF_type);
            this.type = DEF_type;
        }
    }

    // toString method
    public String toString() {
        return (this.type + " " + this.weight);
    }

    // @Override compareTo, compare weights, use names as tie breaker
    public int compareTo(Fruit other) {
        // if other fruit is null, return negative
        if (other == null)
            return -1;
        
        // if this weight is greater, return positive number
        if (this.weight > other.getWeight())
            return 1;
        // if this weight is lesser, return negative number
        else if (this.weight < other.getWeight())
            return -1;
        // weights are the same, break ties based on name
        else
            // return comparison (- = this string first, + = this string last, 0 = equal strings) 
             return this.type.compareTo(other.getType());
    }

}
