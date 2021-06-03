// by Sam Dunny

package Homework05_ShapeTree;

public class Circle implements ShapeInterface{
    
    // Instance variables
    private double radius;
    private String type;
    private double area;

    // Default values
    private double DEF_radius = 1.0;
    private String DEF_type = "DEFAULT CIRCLE";

    // Default constructor
    public Circle() {
        this.radius = this.DEF_radius;
        this.type = DEF_type;
        this.area = Math.PI * Math.pow(this.radius, 2);
    }

    // Parameterized constructor
    public Circle(String aType, double aRad) {
        this.setType(aType);
        this.setRadius(aRad);
        this.area = Math.PI * Math.pow(this.radius, 2);
    }

    // Accessors
    public double getArea() {
        return this.area;
    }
    public double getRadius() {
        return this.radius;
    }
    public String getType() {
        return this.type;
    }

    // Mutators
    public void setRadius(double aRad) {
        if (aRad > 0.0)
            this.radius = aRad;
        else {
            System.out.println("CIRCLE: invalid[" + aRad + "], using default radius");
            this.radius = DEF_radius;
        }
    }
    public void setType(String aType) {
        if (aType.equalsIgnoreCase("Circle"))
            this.type = aType;
        else
            this.type = DEF_type;
    }
    
    // print all object attributes
    public String toString() {
        return (this.type + " Radius: " + this.radius + 
                            " Area: " + this.area);
    }

    // @Override
    // comparison based on shapes area
    public int compareTo(ShapeInterface other) {
        if (this.area == other.getArea())
            return 0;
        if (this.area < other.getArea())
            return -1;
        else
            return 1;
    }

    // boolean comparison based on type and area
    public boolean equals(ShapeInterface other) {
        if (this.type.equalsIgnoreCase(other.getType()) &&
            this.area == other.getArea()) {
                return true;
        }
        return false;
    }
}