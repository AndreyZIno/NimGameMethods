/*
 * Date: 10/14/2020
 * Title: Nim Game
 * Author: Andrey Zinovyev
 * Description: A game in which 2 players take turns to remove starts from a pile,
 * once someone has to take the last one they lose!
 */

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class NimGame {
	
	public static void main(String[] args) {
    	
		// Make scanner.
		Scanner reader = new Scanner(System.in);
		
		// Create a random object to randomize the pile sizes.
		Random rn = new Random();
		
		// Variables.
		String playerOne, playerTwo, pickPile;
		
		int currentPlayer = 1;
		
		int A, B, C;
		
		int remove = 0;
		
		// Number of nims limit.
		int nim = 10;
		
		// Randomly generate numbers from 1-9 in each pile.
		A = rn.nextInt(nim) + 1;
		B = rn.nextInt(nim) + 1;
		C = rn.nextInt(nim) + 1;
		System.out.println("Welcome to Nim! Please type in your names!");
		// Get player names.
		System.out.print("Player 1, what is your name? ");
		playerOne = reader.nextLine();
		
		System.out.print("Player 2, what is your name? ");
		playerTwo = reader.nextLine();
		
		// Loop which will keep the game going until there are no piles left.
		while (A != 0 || B != 0 || C != 0) {
			
			// Fancy display (row).
			System.out.print("A: ");
			for (int j = 0; j < A; j++) {
				System.out.print("*");
			}
			
			System.out.print(" (" + A + ")");
			
			System.out.println();
			System.out.print("B: ");
			for (int j = 0; j < B; j++) {
				System.out.print("*");
			}
			
			System.out.print(" (" + B + ")");
			
			System.out.println();
			System.out.print("C: ");
			for (int j = 0; j < C; j++) {
				System.out.print("*");
			}
			
			System.out.print(" (" + C + ")");
			System.out.println();
			// System.out.println("A: " + A + " B: " + B + " C: " + C);
			
			// Asks player chronologically which pile to take and how much.
			if (currentPlayer == 1) {
				System.out.print(playerOne + ", please choose a pile: ");
			}
			
			else if (currentPlayer == 2) {
				System.out.print(playerTwo + ", please choose a pile: ");
			}
			
			pickPile = reader.nextLine();
			pickPile = pickPile.toUpperCase();
			
			// Check is user said to take 0 from pile.
			while (pickPile.equals("A") && A == 0 || pickPile.equals("B") && B == 0|| pickPile.equals("C") && C == 0) {
				System.out.println("Nice try, but that pile is already empty!");
				pickPile = reader.nextLine();
				pickPile = pickPile.toUpperCase();
			}
			
			// Check is user did not enter a pile.
			while (!pickPile.equals("A") && !pickPile.equals("B") && !pickPile.equals("C")) {
				System.out.println("You have entered an invalid input, try again.");
				pickPile = reader.nextLine();
				pickPile = pickPile.toUpperCase();
			}
			pickPile = pickPile.toUpperCase();
			
			// 
			boolean mayError = true;
			boolean errorCaught = false;
			
			// Check if user has typed in a non-int when removing from pile.
			while (mayError) {
				
				try {
					System.out.println("How much do you want to remove from pile " + pickPile + "?");
					remove =  reader.nextInt();
					errorCaught = false;
					mayError = false;
					
				}
				catch (InputMismatchException e) {
					
					errorCaught = true;
				}
				if (errorCaught == false) {
					mayError = false;
				}
				if (errorCaught == true) {
					System.out.println("That is a not a number! Please enter an Integer");
					reader.nextLine();
				}
				
			}
			
			// Check if the number entered is not in range.
			while ((pickPile.equals("A") && remove > A) || (pickPile.equals("B") && remove > B) || (pickPile.equals("C") && remove > C) || remove <= 0 ) {
				System.out.println("Make sure you are entering a number in the range of the pile!");
				mayError = true;
				errorCaught = false;
				while (mayError) {
					// Ask for user's input, if it is oka
					try {
						System.out.println("How much do you want to remove from pile " + pickPile + "?");
						remove =  reader.nextInt();
						errorCaught = false;
						mayError = false;
						
					}
					// Catch if the user inputs a wrong type of input and ask again
					catch (InputMismatchException e) {
						
						errorCaught = true;
					}
					if (errorCaught == false) {
						mayError = false;
					}
					if (errorCaught == true) {
						System.out.println("That is a not a number! Please enter an Integer");
						reader.nextLine();
					}
					
				}
			}
			
			// Update the piles.
			if (pickPile.equals("A")) {
				A -= remove;
			}
			
			else if (pickPile.equals("B")) {
				B -= remove;
			}
			
			else if (pickPile.equals("C")) {
				C -= remove;
			}
			
			// Alternate players.
			if (currentPlayer == 1) {
				currentPlayer = 2;
			}
			
			else if (currentPlayer == 2) {
				currentPlayer = 1;
			}
			
			// Check if there is only one nim left to check for loser.
			int pileSum = A + B + C;
			
			if (pileSum == 1) {
				
				// Update fancy display.
				System.out.print("A: ");
				for (int j = 0; j < A; j++) {
					System.out.print("*");
				}
				System.out.print(" (" + A + ")");
				
				System.out.println();
				System.out.print("B: ");
				for (int j = 0; j < B; j++) {
					System.out.print("*");
				}
				System.out.print(" (" + B + ")");
				
				System.out.println();
				System.out.print("C: ");
				for (int j = 0; j < C; j++) {
					System.out.print("*");
				}
				System.out.print(" (" + C + ")");
				System.out.println();
				
				System.out.println();
				
				System.out.print("Player " + currentPlayer + " you have to pick the last NIM, you lose.");
				break;
			}
			
			reader.nextLine();
		}
		
		reader.close();
	}
	
}
