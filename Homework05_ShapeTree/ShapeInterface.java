// by Sam Dunny

package Homework05_ShapeTree;

public interface ShapeInterface extends Comparable<ShapeInterface>{

    // Accessors
    public double getArea();
    public String getType();

    // Mutators
    public void setType(String aType);

    // Print shape's attributes
    public String toString();

    // comparison functions
    public int compareTo(ShapeInterface other);
    public boolean equals(ShapeInterface other);
}
