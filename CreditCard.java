import java.util.Scanner;

/** 
 * CreditCard class:  Have the user input a number to store as a credit card number
 * 
 * @author Nathan Samano
 * October 4, 2013 (Sophmore Year)
 *
 */

public class CreditCard {

	public static final int MAX_NUM = 16;   // maximum number of integers for the credit card number
	
	private String userString;  // stores what the user types in as the credit card number
	private char[] charArray; // store each number in the credit card number as separate characters
	private int[] number;    // credit card number as integer
	private Boolean valid;  // state whether or not the credit card is valid
	//private String array[][]; // for more than one credit card (extra)
	
	
	////////////// Constructor //////////////
	
	public CreditCard() {                // initialize variables
		userString = new String("");
		number = new int[MAX_NUM];
		for (int i=0; i<MAX_NUM; i++) {
			number[i] = 0;
		} // for
		valid = false;
	}
	
	public CreditCard(String userString) {  // one argument constructor handles user input
		this();  // reference to zero argument constructor
		char[] charArray;
		charArray = userString.toCharArray();  // convert userInput string to charArray of individual characters
		String temp = new String();  // create temporary string to store characters
		for (int i=0; i < userString.length(); i++) { // numbers '_', '-', '\t'
			if (charArray[i] >= '0' && charArray[i] <= '9') { // put integer in temp
				temp = temp + charArray[i];
				valid = true;
			}
			else if (charArray[i] == ' ' || charArray[i] == '-' || charArray[i] == '\t') { // disregard whitespace and dashes
				valid = true;
				continue;
			}
			else { // print error if another character is entered
				System.out.println("Error: Only numbers, spaces, and dashes are valid characters");
				valid = false;
				break;
			}
		}
		//System.out.println("Before conversion to charArray: " + temp); // test the value of temp
		charArray = temp.toCharArray();
		//System.out.println("After Conversion to charArray:  " + temp); // test the value of temp
		if (valid == true) { // this if statement is necessary if the first 16 numbers make a valid card number and has additional characters after
			for (int i=0; i < MAX_NUM; i++) {
				if (charArray.length == MAX_NUM) {
					number[i] = charArray[i] - '0';  // convert charArray to intArray
					isValid(number);                 // test if number is valid
				}
				else {
					System.out.println("Error: Credit card number must be 16 numbers");
					valid = false;
					break;
				}
			}
		}
	} // constructor
	
	///////////// toString /////////////
	
	public String toString() {
		if (valid == true) {
			//return userString + charArray;
			return formatNumber(number) + " is a valid credit card number.";
		}
		else {
			return "Invalid credit card number.";
		}
	} // toString
	
	///////////// Methods /////////////
	
	public void isValid(int[] otherNum) {       //algorithm for a valid credit card number, every other number starting with
		int sum = 0;                            //the first is multiplied by 2 and added all together with the other numbers
		for (int i=0; i < MAX_NUM; i+=2) {      //if the doubled number is a double digit like 12 add 1 and 2 rather than 12
			int num = otherNum[i]*2;
												//System.out.println("num" + num);
			int div = num/10;
												//System.out.println("div" + div);
			int mod = num%10;
												//System.out.println("mod" + mod);
			sum = sum + div + mod;
												//System.out.println("total sum" + sum);
		}
		for (int i=1; i < MAX_NUM; i+=2) {
			int num = otherNum[i];
			sum = sum + num;
		}
												//System.out.println(sum);
		if (sum%10 == 0) {
			valid = true;
		}
		else {
			valid = false;
		}
	}
	
	public String formatNumber(int[] cardNum) {
		String output = new String(); /* temporary string to hold the number */
		for (int i=0; i < MAX_NUM; i++) {
			if (i==4 || i==8 || i==12) {
				output = output + "-" + cardNum[i];      // add a dash every 4th number
			}
			else output = output + cardNum[i];
		}
		return output;
	} // formatNumber()
	
} // class
