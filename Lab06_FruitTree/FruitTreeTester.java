// by Sam Dunny

package Lab06_FruitTree;

import java.util.*;
import java.io.*;
public class FruitTreeTester {

    // public String pckg_Name = this.getClass().getPackage().getName();

    public static void main(String[] args) {

        System.out.println("Welcome to the fruit tree!\nPlease enter a Fruit File Name");

        // initialize the binary search tree data structure
        LinkedBinarySearchTree<Fruit> fruitTree = new LinkedBinarySearchTree<Fruit>();

        // initialize scanner
        Scanner keyboard = new Scanner(System.in);

        // get package name for file access
        String pckg_Name = FruitTreeTester.class.getPackageName();

        String fileName = keyboard.nextLine();
        fileName = pckg_Name + "/" + fileName;
        
        // try-catch block for 'fileNotFound' exception
		try {
			// create new file scanner
			Scanner fruitScanner = new Scanner(new File(fileName));

            // go through input file until EOF
            System.out.println("Reading from file\n");
			while (fruitScanner.hasNextLine()) {
                // capture new line
                String newLine = fruitScanner.nextLine();

                // ensure line contains right titles before creating new object
                if (!newLine.contains("Apple") &&
                    !newLine.contains("Orange") &&
                    !newLine.contains("Banana") &&
                    !newLine.contains("Kiwi") && 
                    !newLine.contains("Tomato")) {
                        System.out.println("Not valid FRUIT: [" + newLine + "]");
                        continue;
                }

                // split line on the tab to seperate names and weights
                String[] fruitAtts = newLine.split("\t");

                // didnt split properly
                if (fruitAtts.length != 2) {
                    System.out.println("Not valid formatting: [" + newLine + "]");
                    continue;
                }

                // instantiate and initialize new fruit
                Fruit newFruit = new Fruit(Double.parseDouble(fruitAtts[1]), fruitAtts[0]);

                // add to bstree
                fruitTree.add(newFruit);
            }

            // close the file scanner
			fruitScanner.close();
		}
		// catch block, in cases of "File Not Found"
		catch (IOException e) {
			System.out.println(e);
		}

        // at this point, we have successfully added all fruit to the tree

        // print in order
        System.out.println("\nPrinting in-order\n");
        fruitTree.printInOrder();
        System.out.println();

        // print pre order
        System.out.println("Printing pre-order\n");
        fruitTree.printPreOrder();
        System.out.println();

        // print post order
        System.out.println("Printing post-order\n");
        fruitTree.printPostOrder();
        System.out.println();

        // remove an item
        Fruit del_fruit = new Fruit(0.4859853412170728, "Apple");
        System.out.println("Deleting " + del_fruit.toString());
        fruitTree.remove(del_fruit);

        // print in order
        System.out.println("Printing in-order\n");
        fruitTree.printInOrder();
        System.out.println();

        keyboard.close();
    }
    
}
