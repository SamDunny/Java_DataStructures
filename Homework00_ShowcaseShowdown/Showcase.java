// by Sam Dunny

package Homework00_ShowcaseShowdown;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Showcase {

    // Instance variables
    private Prize itemsList[];      // list for all input items
    private Prize showcase[];       // list for showcase items

    private int itemCount = 0;      // amount of items in items list
    private int minCount = 50;      // the minimum amount of items required in items list
    private int showcaseSize = 0;   // the size for the showcase

    // no default constructor, useless in frontend

    // parameterized constructor
    public Showcase(String fileName, final int showcaseSize) {
        try {
			// create new file scanner, count number of items in the list to ensure there are at least 50 items
			Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                itemCount++;
                fileScanner.nextLine();
            }
            
            // exit program with error message if list has fewer than 50 items
            if (itemCount < minCount) {
                System.out.println("ERROR: Input list size must exceed 50 VALID items [current list has " + itemCount + " VALID items]");
                System.exit(1);
            }

            // set the showcase size, item and showcase sizes
            this.showcaseSize = showcaseSize;
            this.itemsList = new Prize[itemCount];
            this.showcase = new Prize[this.showcaseSize];

            // start index to add prizes at 0
            int items_index = 0;

            // redeclare file scanner to reset it to top of file
			fileScanner = new Scanner(new File(fileName));

            // go through input file until EOF, add all prizes to items list
			while (fileScanner.hasNextLine()) {
                // split the new line on tabs into string values for name and price
                String nextFileLine = fileScanner.nextLine();

                // check to see if line is correct syntax (has a tab, could be more stringent HERE), add prize if true, skip if not
                if (nextFileLine.contains("\t")) {
                    String[] tempPrizeVals = nextFileLine.split("\\t");
                    // create new prize with delimited values
                    Prize newPrize = new Prize(Integer.parseInt(tempPrizeVals[1]), tempPrizeVals[0]);

                    //System.out.println(newPrize.toString());

                    // add prize to prize list
                    itemsList[items_index] = newPrize;
                    items_index++;
                }
                else
                    continue;
            }
            // close the file scanner
			fileScanner.close();
		}
		// catch block, in cases of "File Not Found"
		catch (IOException e) {
			System.out.println(e);
		}

        // at this point, we have an initialized showcase and a full itemsList of size 'itemCount'

        // make new random number generator
        Random rand = new Random();

        // find random numbers for indexes in the items list to populate the showcase
        for (int i = 0; i < this.showcaseSize; i++) {
            int rand_roll = rand.nextInt(itemsList.length);
            //System.out.println("Random = " + rand_roll);
            showcase[i] = itemsList[rand_roll];
            //System.out.println(showcase[i].getName());
        }

        // populated showcase and items list
    }

    // Accessors
    public int getPrizeListSize() {
        return this.itemsList.length;
    }
    public int getShowcaseSize() {
        return this.showcase.length;
    }
    public Prize[] getShowcase() {
        return this.showcase;
    }

    public void printShowcaseNames() {
        for (int i = 0; i < this.showcase.length; i++) {
            System.out.println((i+1) + ":\t" + showcase[i].getName());
        }
    }
    public int getShowcaseTotalPrice() {
        int sum = 0;
        for (int i = 0; i < this.showcase.length; i++) {
            sum+=showcase[i].getPrice();
        }
        return sum;
    }

    // reshuffle function to reshuffle showcase
    public void reshuffleShowcase() {
        // make new random number generator
        Random rand = new Random();

        // find random numbers for indexes in the items list to populate the showcase
        for (int i = 0; i < this.showcaseSize; i++) {
            int rand_roll = rand.nextInt(itemsList.length);
            //System.out.println("Random = " + rand_roll);

            showcase[i] = itemsList[rand_roll];
            //System.out.println(showcase[i].getName());
        }
    }
}