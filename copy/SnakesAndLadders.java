package Assignment3.copy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SnakesAndLadders {

    private static final int BOARD_SIZE = 100;
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;

    private int[] board;
    private int numPlayers;
    private int[] playerPositions;
    private int currentPlayerIndex;

    // Constructor with parameter to set the number of players
    public SnakesAndLadders(int numPlayers) {
        // Validate the number of players
        if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
            throw new IllegalArgumentException("Number of players must be between 2 and 4 inclusive.");
        }

        // Initialize the board
        initializeBoard();

        // Initialize the players
        initializePlayers(numPlayers);

        // Set the number of players
        this.numPlayers = numPlayers;
    }

    private void initializeBoard() {
        // Initialize the board array
        board = new int[BOARD_SIZE];

        // Set snake relationships
        board[15] = -10;
        board[47] = -18;
        board[63] = -4;
        board[78] = -50;
        board[92] = -25;
        board[94] = -71;
        board[96] = -21;
        board[97] = -20;

        // Set ladder relationships
        board[0] = 37;
        board[3] = 10;
        board[8] = 22;
        board[20] = 21;
        board[27] = 56;
        board[35] = 8;
        board[50] = 17;
        board[70] = 21;
        board[79] = 20;
    }

    // Getter for the number of players
    public int getNumPlayers() {
        return numPlayers;
    }

    // Getter for the board
    public int[] getBoard() {
        return board;
    }

    private int flipDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private void initializePlayers(int numPlayers) {
        this.numPlayers = numPlayers;
        playerPositions = new int[numPlayers];

        // Set initial positions to player numbers (1, 2, 3, ...)
        for (int i = 0; i < numPlayers; i++) {
            playerPositions[i] = i;
        }

        currentPlayerIndex = 0; // Start with the first player
    }


    



    // Method to determine the order of playing
 // Method to determine the order of playing
 // Method to determine the order of playing
    private void determineOrderOfPlaying() {
        System.out.println("Now deciding which player will start playing.");

        // Initialize the players
        initializePlayers(numPlayers);

        // Array to store the dice values for each player
        int[] diceValues = new int[numPlayers];

        // Roll dice for each player and display the result
        for (int i = 0; i < numPlayers; i++) {
            diceValues[i] = flipDice();
            System.out.println("Player " + (i + 1) + " got a dice value of " + diceValues[i]);
        }

        // Sort players based on dice values
        sortPlayers(diceValues);

        // Display the determined order
        System.out.print("Reached final decision on order of playing: ");
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + (playerPositions[i] + 1));
            if (i < numPlayers - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    private void sortPlayers(int[] diceValues) {
        // Create an array to store player indices
        Integer[] indices = new Integer[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            indices[i] = i;
        }

        // Sort player indices based on dice values in descending order
        Arrays.sort(indices, Comparator.comparingInt((Integer i) -> diceValues[i]).reversed());

        // Check for ties
        boolean tie = false;
        for (int i = 1; i < numPlayers; i++) {
            if (diceValues[indices[i]] == diceValues[indices[i - 1]]) {
                tie = true;
                break;
            }
        }

        if (tie) {
            System.out.println("A tie was achieved. Attempting to break the tie.");

            // Display dice rolls for tied players
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Player " + (indices[i] + 1) + " got a dice value of " + diceValues[indices[i]]);
            }

            // Break the tie
            Arrays.sort(indices, Comparator.comparingInt((Integer i) -> diceValues[i]).reversed());

            System.out.println("Reached final decision on order of playing: ");
            for (int i = 0; i < numPlayers; i++) {
                System.out.print("Player " + (indices[i] + 1));
                if (i < numPlayers - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            // No tie, proceed with the regular order
            // Create a new array to store the sorted order of playing
            int[] newPlayerOrder = Arrays.copyOf(playerPositions, numPlayers);

            // Rearrange player order based on the sorted indices
            for (int i = 0; i < numPlayers; i++) {
                playerPositions[i] = newPlayerOrder[indices[i]];
            }

            // Update currentPlayerIndex to point to the first player after sorting
            currentPlayerIndex = 0;
        }
    }


    private boolean isGameOver() {
        for (int position : playerPositions) {
            if (Math.abs(position) >= BOARD_SIZE - 1) {
                return true; // The game is over if any player reaches or exceeds square 100
            }
        }
        return false; // The game is not over yet
    }

    private int findWinner() {
        int winner = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < numPlayers; i++) {
            int distanceToWin = BOARD_SIZE - 1 - Math.abs(playerPositions[i]);

            if (distanceToWin < minDistance) {
                minDistance = distanceToWin;
                winner = i;
            }
        }

        return winner;
    }

    // Method to get player information based on the current position
    private String getPlayerInfo(int playerIndex, int position) {
        if (position == 0) {
            return "now in square 0";
        } else if (Math.abs(position) < BOARD_SIZE) {
            int absPosition = Math.abs(position);
            if (position < 0) {
                return "gone to square " + absPosition + " then down to square " + Math.abs(board[absPosition]) + ";";
            } else {
                return "gone to square " + absPosition + ";";
            }
        } else {
            return "out of bounds";
        }
    }

    


    public void play() {
        System.out.println("Game is played by " + numPlayers + " players.");

        // Initialize the players only if it's the first move
        
            determineOrderOfPlaying();
        


        while (!isGameOver()) {
            int currentPlayerPosition = playerPositions[currentPlayerIndex];
            int diceResult = flipDice();

         // Calculate the new position based on the dice roll
            int newPosition = (currentPlayerPosition == 0) ? diceResult : currentPlayerPosition + diceResult;

            // Check if the new position is greater than or equal to square 100
            if (newPosition >= BOARD_SIZE) {
                // Calculate the excessive amount
                int excessiveAmount = newPosition - (BOARD_SIZE - 1);
                // Move the player backward with the excessive amount
                newPosition = BOARD_SIZE - 1 - excessiveAmount;
            }

            // Update the player position, ensuring it stays within bounds
            playerPositions[currentPlayerIndex] = Math.min(newPosition, BOARD_SIZE - 1);

            // Calculate the position after encountering a ladder
            int newPositionAfterLadder = board[newPosition];
            if (newPositionAfterLadder > 0) {
                // Check if another player is already on the top of the ladder
                if (playerPositions[currentPlayerIndex] == newPositionAfterLadder) {
                    // Handle the conflict, e.g., move the player to the next available square
                    newPosition = findNextAvailableSquare(newPositionAfterLadder);
                } else {
                    // Move the player to the top of the ladder
                    newPosition = Math.min(newPositionAfterLadder, BOARD_SIZE - 1);
                }
            }

            // Update the player position, ensuring it stays within bounds
            playerPositions[currentPlayerIndex] = Math.min(newPosition, BOARD_SIZE - 1);

            // Print the move information
            System.out.println("Player " + (currentPlayerIndex + 1) + " got a dice value of " + diceResult +
                    "; " + getPlayerInfo(currentPlayerIndex, playerPositions[currentPlayerIndex]));

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        }

        // Game over, print the winner
        int winner = findWinner();
        System.out.println("Player " + (winner + 1) + " wins! Game over.");
    }



    private int findNextAvailableSquare(int position) {
        // Implement your logic to find the next available square
        // For simplicity, let's assume moving to the next square for now
        return Math.min(position + 1, BOARD_SIZE - 1);
    }
}
