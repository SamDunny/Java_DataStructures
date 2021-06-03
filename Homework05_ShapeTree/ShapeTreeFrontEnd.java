package Homework05_ShapeTree;

import java.io.*;
import java.util.*;
public class ShapeTreeFrontEnd {

    public static void main(String[] args) {

        System.out.println("Welcome to the shape tree tester!\n");

        LinkedBinarySearchTree<ShapeInterface> shapeTree = new LinkedBinarySearchTree<ShapeInterface>();

        // try-catch block for 'fileNotFound' exception
		try {
			// create new file scanner
			Scanner shapeScanner = new Scanner(new File("Homework05_ShapeTree/shapes.txt"));
				
			// go through input file until EOF
            System.out.println("Reading from file\n");
			while (shapeScanner.hasNextLine()) {
                // capture new line
                String newLine = shapeScanner.nextLine();

                // ensure that the line at least contaisn a shape before creating new object
                if (!newLine.contains("Rectangle") &&
                    !newLine.contains("Right Triangle") &&
                    !newLine.contains("Circle")) {
                        System.out.println("Not valid SHAPE: [" + newLine + "]");
                        continue;
                }

                // instantiate new object
                ShapeInterface newShape;

                // split line on tab
                String[] nameSplit = newLine.split("\t");

                // create new shape based on title
                if (nameSplit[0].equalsIgnoreCase("Rectangle")) {
                    newShape = new Rectangle(nameSplit[0], Double.parseDouble(nameSplit[1]), Double.parseDouble(nameSplit[2]));
                    shapeTree.add(newShape);
                    System.out.println(newShape.toString());
                }
                else if (nameSplit[0].equalsIgnoreCase("Right Triangle")) {
                    newShape = new RightTriangle(nameSplit[0], Double.parseDouble(nameSplit[1]), Double.parseDouble(nameSplit[2]));
                    shapeTree.add(newShape);
                    System.out.println(newShape.toString());
                }
                else if (nameSplit[0].equalsIgnoreCase("Circle")) {
                    newShape = new Circle(nameSplit[0], Double.parseDouble(nameSplit[1]));
                    shapeTree.add(newShape);
                    System.out.println(newShape.toString());
                }
                // if it is not one of the 3 shapes, ignore it
                else {
                    System.out.println("Not properly formatted LINE: " + newLine + "]");
                    continue;
                }
			}
			// close the file scanner
			shapeScanner.close();
		}
		// catch block, in cases of "File Not Found"
		catch (IOException e) {
			System.out.println(e);
		}

        // at this point, we have an initialized and full linked list full of shape interfaces

        // print pre order
        System.out.println("\nPrinting pre-order\n");
        shapeTree.printPreOrder();
        System.out.println();

        // print in order
        System.out.println("Printing in-order\n");
        shapeTree.printInOrder();
        System.out.println();

        // print post order
        System.out.println("Printing post-order\n");
        shapeTree.printPostOrder();
        System.out.println();

        // retrieve max area
        System.out.println("The max area is: " + shapeTree.findMaxAreaInTree().getArea());

        // creating instance of shape we wish to remove from list
        ShapeInterface del_Shape = new Rectangle("Rectangle", 2.0, 7.0);

        // assuming no duplicate areas are present, this works
        System.out.println("\nDeleting " + del_Shape.toString() + "\n");
        shapeTree.remove(del_Shape);
        System.out.println("Printing in-order\n");
        shapeTree.printInOrder();

        // again, assuming no duplicates
        // had to create default shape with area 30 to keep LinkedBinarySearchTree as general as possible
        ShapeInterface cutoff = new Rectangle("DEFAULT", 15.0, 2.0);
        System.out.println("\nDeleting values larger than " + cutoff.getArea() + "\n");
        shapeTree.deleteValuesGreaterThan(cutoff);
        System.out.println("Printing in-order\n");
        shapeTree.printInOrder();

    }
    
}
