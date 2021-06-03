// by Sam Dunny

package Homework05_ShapeTree;

public class RightTriangle implements ShapeInterface{

    // Instance variables
    private double x_dim;
    private double y_dim;
    private String type;
    private double area;

    // Default values
    private double DEF_x_dim = 1.0;
    private double DEF_y_dim = 1.0;
    private String DEF_type = "DEFAULT RIGHT TRIANGLE";

    // Default constructor
    public RightTriangle() {
        this.x_dim = this.DEF_x_dim;
        this.y_dim = this.DEF_y_dim;
        this.type = DEF_type;
        this.area = (this.x_dim * this.y_dim)/2.0;
    }

    // Parameterized constructor
    public RightTriangle(String aType, double aX, double aY) {
        this.setType(aType);
        this.setXDimension(aX);
        this.setYDimension(aY);
        this.area = (this.x_dim * this.y_dim)/2.0;
    }

    // Accessors
    public double getArea() {
        return this.area;
    }
    public double getXDimension() {
        return this.x_dim;
    }
    public double getYDimension() {
        return this.y_dim;
    }
    public String getType() {
        return this.type;
    }

    // Mutators
    public void setXDimension(double aX) {
        if (aX > 0.0)
            this.x_dim = aX;
        else {
            System.out.println("RIGHT TRIANGLE: invalid[" + aX + "], using default x-dimension");
            this.x_dim = DEF_x_dim;
        }
    }
    public void setYDimension(double aY) {
        if (aY > 0.0)
            this.y_dim = aY;
        else {
            System.out.println("RIGHT TRIANGLE: invalid[" + aY + "], using default y-dimension");
            this.y_dim = DEF_y_dim;
        }
    }
    public void setType(String aType) {
        if (aType.equalsIgnoreCase("Right Triangle"))
            this.type = aType;
        else
            this.type = DEF_type;
    }
    
    // print all object attributes
    public String toString() {
        return (this.type + " Side 1: " + this.x_dim + 
                            " Side 2: " + this.y_dim + 
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