package Assignment3;

import java.util.Arrays;
import java.util.Random;

public class SnakesAndLadders {

	private int numbOfPlayers;
	private int[] board;

	// DEFAULT CONST
	public SnakesAndLadders() {
		// Regular Places
		board = new int[100];
		for (int i = 0; i < board.length; i++) {
			board[i] = 0;
		}
		// number of players
		numbOfPlayers = 2;
		// sankes
		board[15] = -10;
		board[47] = -18;
		board[63] = -4;
		board[78] = -50;
		board[92] = 68 - 93;
		board[94] = 24 - 95;
		board[96] = 76 - 97;
		board[97] = 78 - 98;
		// ladders
		board[0] = 38 - 1;
		board[3] = 14 - 4;
		board[8] = 31 - 9;
		board[20] = 42 - 21;
		board[27] = 84 - 28;
		board[35] = 44 - 36;
		board[50] = 67 - 51;
		board[70] = 91 - 71;
		board[79] = 100 - 80;

	}

	public SnakesAndLadders(int np) {
		numbOfPlayers = np;

	}

	public int getNumbOfPlayers() {
		return numbOfPlayers;
	}

	public void setNumbOfPlayers(int numbOfPlayers) {
		this.numbOfPlayers = numbOfPlayers;
		if (numbOfPlayers < 2 || numbOfPlayers > 4) {
			System.out.println(
					"Invalid Number Of Players. \n" + "Number of plyers should be between 2 and 4 inclusively.");
		}
	}

	public static int flipDice() {
		Random rd = new Random();
		int dice = rd.nextInt(6) + 1;

		return dice;
	}

	public void play() {
		System.out.println("Game is Played by " + getNumbOfPlayers() + " players ");// • Game is Played by x players
																					// (where x is the number of players
																					// set for that game);
		System.out.println("Now deciding which player will start playing.");// • Now deciding which player will start
		int[][] order = new int[numbOfPlayers][2];																	// playing
		int i;
		int j;
		for (i = 0; i < order.length; i++) {
			 order[i][0] = i + 1;  // Player number
	         order[i][1] = flipDice();  // Dice value
			System.out.println("Player " + order[i][0] + " got a dice value of " + order[i][1]);// • Player 1 got a dice value
																							// of 5
			for(j = i - 1; j >= 0; j--) {
				while(order[i][1] == order[j][1]) {
					System.out.println("A tie was achieved between Player " + order[i][1] + " and Player " + order[j][1] + ". \n"
							+ "Attempting to break the tie...");// A tie was achieved between Player 2 and Player 3. Attempting to break the tie...
					order[i][1] = flipDice();
			         order[j][1] = flipDice(); 																
					System.out.println("Player " + order[j][0] + " got a dice value of " + order[j][1]);
 					System.out.println("Player " + order[i][0] + " got a dice value of " + order[i][1]);
				}
				
			}
		}

	
		Arrays.sort(order);
	System.out.println("Players will play in the following order:");

	for (i = 0; i < order.length; i++) {
		////			•	Reached final decision on order of playing: Player 1, Player 3, Player 2
			System.out.println("Reached final decision on order of playing: Player 1, Player 3, Player 2");
			//			
				}
	}

	

//	•	Game is Played by x players (where x is the number of players set for that game); 
//			•	Now deciding which player will start playing; 
//	Attempting to break the tie 
//	•	Player 1 got a dice value of 5; now in square 5 	
// •	If the reached square has a bottom of a ladder, then the player moves up to the square that has the top of the ladder. 
	// For instance, if a player is at square 33, and the flipped dice value was 3,
	// then the player moves to square 36, which in turn will end moving the player
	// up to square 44.
	// • If the reached square has a head of a snake, then the player moves down the
	// square that has the tail of the snake. For instance, if a player is at square
	// 77,
	// and the flipped dice value 2, then the player moves to square 79 (which has
	// the tip of the snake’s head), which in turn end moving the player down to
	// square 19.
//	•	If a player is close to 100, and the dice value exceeds the maximum possible moves, the player moves backward with the excessive amount. 
//	For instance, if a player is at square 96 and the dice value is 5, then the player moves to 99 (that is 4 moves to 100, then 1 move backward to 99). 
}
