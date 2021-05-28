// by Sam Dunny

package Homework00_ShowcaseShowdown;

import java.util.Scanner;
public class ShowcaseGame {

    public static final int showcaseSize = 5;
    public static void main(String[] args) {

        // load prize list
        Showcase showcase = new Showcase("Homework00_ShowcaseShowdown/prizeList.txt", showcaseSize);
        Scanner keyboard = new Scanner(System.in);

        // game loop condition
        boolean gameRunning = true;

        while(gameRunning) {

            //System.out.println(showcase.getShowcaseSize());

            // welcome prompt
            System.out.println("----------------------------------\n" +
                                "Welcome to the showcase show down!\n" + 
                                "----------------------------------\n" + 
                                "\nYour prizes are:\n");

            // display the names of the items on display
            showcase.printShowcaseNames();

            // gather user guess
            System.out.println("\nYou must guess the total cost of all without going over\nEnter your guess");
            int usr_guess = keyboard.nextInt();
            keyboard.nextLine();

            // report guess and actual price
            System.out.println("You guessed " + usr_guess + " the actual price is " + showcase.getShowcaseTotalPrice());

            // user guessed too high
            if (usr_guess > showcase.getShowcaseTotalPrice())
                System.out.println("I'm sorry but that was over... You get nothing");

            // user guessed something too low
            else if (usr_guess <= (showcase.getShowcaseTotalPrice() - 2000))
                System.out.println("I'm sorry but that guess was bad. You lose for being bad.");

            // user entered exact amount
            else if (usr_guess == showcase.getShowcaseTotalPrice())
                System.out.println("Your guess was equal! You win!");

            // user guess is in acceptable range
            else
                System.out.println("Your guess was under! You win!");

            System.out.println("Would you like to play again? Enter 'no' to quit");
            String usr_resp = keyboard.nextLine();
            if (usr_resp.equalsIgnoreCase("no")) {
                gameRunning = false;
            }
            // reshuffle the showcase if continuing
            else
                showcase.reshuffleShowcase();
        }

        System.out.println("Goodbye!");
        keyboard.close();
    }
}
