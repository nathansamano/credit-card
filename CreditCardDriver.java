/*
 * Nathan Samano
 * October 4, 2013 (Sophmore Year)
 * This is the client code of CreditCard
 */


import java.util.Scanner;

public class CreditCardDriver {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String userInput = new String();
		
		while(true) {
			System.out.println("Enter Credit Card Number: "); // print a prompt
			userInput = keyboard.nextLine(); // read in user's response, store in userInput
			
			if (userInput.equals("exit")) { // see if user typed "exit" using .equals => userInput.equals("exit");
				keyboard.close(); // close keyboard resource before exiting
				System.exit(0); // exit
			}
			
			// create a new credit card, give it the userInput String
			CreditCard cardObject = new CreditCard(userInput);
			System.out.println(cardObject);			
		}

	}

}
