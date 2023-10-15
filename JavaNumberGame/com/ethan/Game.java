// Imported classes used in this program:
package com.ethan;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Game 
{
    public void play()
    {
         // Declaring variables and instances of objects:
        Random rand = new Random();
        Integer hiddenNumber = rand.nextInt(100);
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        String userInput = "";
        Integer userGuess = 0;

        // The user gets important info that only shows at the beginning of the program:
        System.out.println("Welcome to the hidden number game!");
        System.out.println(
                "Hit ENTER at any time to see the numbers you have already guessed, as well as a hint as to where the number is. ");
        System.out.println("You may begin guessing (1-100).");

        // This loop is the gut of the program and runs until the correct number is
        // guessed:
        try (Scanner newObj = new Scanner(System.in)) {
            while (userGuess != hiddenNumber) {
                userInput = newObj.nextLine();
                userGuess = checkIfInteger(userInput);

                if (userGuess == null) {
                    listOfGuesses(guesses, hiddenNumber);
                }

                else if (userGuess > 100 || userGuess < 0) {
                    System.out.println("Please enter a number from 1-100.");
                }

                else if (userGuess > hiddenNumber) {
                    System.out.println("The hidden number is LOWER than your guess.");
                    guesses.add(userGuess);
                }

                else if (userGuess < hiddenNumber) {
                    System.out.println("The hidden number is HIGHER than your guess.");
                    guesses.add(userGuess);
                }
            }
        }

        System.out.println("\nYou win! The correct number was " + userGuess + ". You solved it in " + (guesses.size() + 1)
                + " guesses.\n");
    }

    private void listOfGuesses(ArrayList<Integer> guesses, int hiddenNumber) {
        // This method takes the list of previously guessed numbers, places the hidden
        // number in it,
        // and then returns it to the user as a useful list that will be sorted and hide
        // the hidden number.
        guesses.add(hiddenNumber);
        System.out.println("These are the numbers you have guessed so far: ");
        Collections.sort(guesses);
        for (int i : guesses) {
            if (i == hiddenNumber) {
                System.out.print("?, ");
            }

            else {
                System.out.print(i + ", ");
            }
        }

        System.out.print("\b\b  \n");
        guesses.remove(guesses.indexOf(hiddenNumber));
    }

    private Integer checkIfInteger(String userInput) {
        // This method is used to transform a string to an integer, if applicable. This
        // happens everytime a new input is created.
        try {
            Integer.parseInt(userInput);
            return Integer.parseInt(userInput);
        }

        catch (Exception e) {
            // This return value is simply just a product key to help guide it through the
            // upcoming if statements.
            return null;
        }
    }
}