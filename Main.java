package Assignment3;

import java.util.Scanner;

public class Main {
	// -----------------------------------------------------
	// Assignment: [Include Assignment Number]
	// Question:   [Include Question/Part Number, if applicable]
	// Written by: [Include Your Name]
	// Student ID: [Include Your Student ID]
	// -----------------------------------------------------

	// [Additional comments or explanations about the purpose of the program]
	
	// Program Explanation:
	// This program demonstrates basic concepts of Java programming, including the use of classes,
	// loops, arrays, and static methods. The main purpose is to showcase the implementation of a simple
	// algorithm that performs a specific task. As the program progresses, additional comments will be
	// provided to explain the functionality of each section.

	// [Additional comments or explanations about the purpose of the program]
	
	// Main Steps:
	// 1. Initialize variables and arrays as needed.
	// 2. Prompt the user for input or generate input data.
	// 3. Perform necessary calculations or operations using loops and conditionals.
	// 4. Display the results or output to the user.
	// 5. Utilize static methods for reusable code segments.
	// 6. Ensure proper error handling and validation where applicable.


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to MyProgram!");
        System.out.println("Written by: John Doe");
        // Add additional names or information if needed
        System.out.println("Student ID: 123456789");
        System.out.println(); // Empty line for better formatting
        
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = kb.nextLine();
        System.out.println("Hello, " + userName + "!");

        kb.close();
        
        System.out.println("Thank you for using MyProgram. The program has terminated.");
        
        


 
//				•	Player 1 got a dice value of 5; now in square 5 
//				•	Player 3 got a dice value of 6; now in square 6 
//				•	Player 2 got a dice value of 4; gone to square 4 then up to square 14 
//				•	Game not over; flipping again 
//				•	Player 1 got dice value of 4; gone to square 9 then up to square 31 
//				•	Player 3 got dice value of 4; now in square 10 
//				•	Player 2 got dice value of 2; gone to square 16 then down to square 6 
//				•	Game not over; flipping again 
//				•	: 
//				•	: 
//				•	

		SnakesAndLadders myGame = new SnakesAndLadders();
		myGame.setNumbOfPlayers(4);
		myGame.play();
	
		
		
	}

}
